package com.quizmasterdeluxe.usecase.quizfilter;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@MicronautTest
class QuizFilterUseCaseTest {
    @Inject
    private QuizFilterUseCase quizFilterUseCase;

    @Test
    void shouldReturnUserNameWithCorrectUserName() {
        QuizFilterRequest request = new QuizFilterRequest("dipendra", "easy", "9");
        Optional<QuizFilterResponse> response = quizFilterUseCase.execute(request);
        assertTrue(response.isPresent());
        QuizFilterResponse quizFilterResponse = response.get();
        assertEquals("dipendra", quizFilterResponse.getName());
    }
    @Test
    void shouldGetQuestionAndAnswers(){
        QuizFilterRequest request = new QuizFilterRequest("dipendra","easy","9");
        Optional<QuizFilterResponse> response = quizFilterUseCase.execute(request);
        assertTrue(response.isPresent());
        Assertions.assertEquals(0,response.get().getResponseCode());
    }

}