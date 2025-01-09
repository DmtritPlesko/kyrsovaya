package api.demo;

import api.demo.dto.answer.FullAnswerDto;
import api.demo.dto.answer.ShortAnswerDto;
import api.demo.mapper.AnswerMapper;
import api.demo.model.Answer;
import api.demo.repository.AnswerRepository;
import api.demo.service.answer.AnswerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnswerServiceImplTest {

	@Mock
	private AnswerRepository repository;

	@Mock
	private AnswerMapper answerMapper;

	@InjectMocks
	private AnswerServiceImpl answerService;

	@BeforeEach
	void setUp() {
		// Здесь можно добавить дополнительную настройку, если необходимо
	}

	@Test
	void testGetAllAnswers() {
		// Подготовка
		Answer answer1 = new Answer(1L, "Content1");
		Answer answer2 = new Answer(2L, "Content2");
		List<Answer> answers = Arrays.asList(answer1, answer2);
		when(repository.findAll()).thenReturn(answers);

		// Тестирование
		List<ShortAnswerDto> result = answerService.getAllAnswers();

		// Проверка
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	void testAddNewAnswer() {
		// Подготовка
		FullAnswerDto answerDto = new FullAnswerDto("New Content");
		when(answerMapper.toAnswer(any())).thenCallRealMethod();
		when(repository.save(any())).thenReturn(new Answer(1L, "New Content"));
		when(answerMapper.toShortAnswerDto(any())).thenReturn(new ShortAnswerDto("New Content"));

		// Тестирование
		ShortAnswerDto result = answerService.addNewAnswer(answerDto);

		// Проверка
		assertNotNull(result);
		assertEquals("New Content", result.getDescription());
	}

	@Test
	void testDeleteAnswer() {
		// Подготовка
		Long idToDelete = 1L;
		when(repository.findById(idToDelete)).thenReturn(java.util.Optional.of(new Answer(1L, "Content")));

		// Тестирование
		answerService.deleteAnswer(idToDelete);

		// Проверка
		verify(repository).findById(idToDelete);
		verify(repository).deleteById(idToDelete);
	}

	@Test
	void testDeleteNonexistentAnswer() {
		// Подготовка
		Long nonexistentId = 999L;
		when(repository.findById(nonexistentId)).thenReturn(java.util.Optional.empty());

		// Тестирование
		assertThrows(IllegalArgumentException.class, () -> answerService.deleteAnswer(nonexistentId));

		// Проверка
		verify(repository).findById(nonexistentId);
		verify(repository, never()).deleteById(nonexistentId);
	}
}
