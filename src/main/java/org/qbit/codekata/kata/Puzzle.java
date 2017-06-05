package org.qbit.codekata.kata;

import org.qbit.codekata.kata.exception.AppException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Benek on 05.06.2017.
 */
public class Puzzle {

    public static void main(String[] args) throws AppException {

        String appConfig = "META-INF/spring/app-context.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(appConfig);
        WordPuzzle puzzle = ctx.getBean("puzzle", WordPuzzle.class);
        puzzle.setPuzzleWords("ala", "ola");
        List<String> solution = (List<String>) puzzle.findTransition();
        System.out.println("solution: " + solution);
    }
}
