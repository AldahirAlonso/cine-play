package com.cine_play.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface CinePlayAiService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de Gestion de Peliculas {{plataform}}.
            Usa menos de 120 caracteres y hazlo de manera formal y educada, y usa emojis por favor.
            """)
    String generateGreeting(@V("plataform") String plataform);

    @SystemMessage("""
            Eres un experto en cine que recomienda peliculas personalizadas segun los gustos de los usuarios. 
            Debes recomendar maximo 3 peliculas.
            No incluyas peliculas que esten por fuera de la plataforma de Cine-Play.
            """)
    String generateMoviesSuggestion(@UserMessage String userMessage);

}
