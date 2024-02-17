package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas aulas tem o curso? ");
		int amountLessons = sc.nextInt();
		
		List<Lesson> lessons = new ArrayList<>();
		
		for (int i = 1; i <= amountLessons; i++) {
			System.out.println();
			System.out.println("Dados da "+ i +"a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char answer = sc.next().charAt(0);
			
			System.out.print("Título: ");
			sc.next();
			String title = sc.nextLine();
			
			if (answer == 'c') {
				
				System.out.print("URL do vídeo: ");
				String url = sc.next();
				
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();
				
				lessons.add(new Video(title, url, seconds));
				
			} else {
				
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				
				System.out.print("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				
				lessons.add(new Task(title, description, questionCount));
			}
		}
		
		int sumDuration = 0;
		
		for (Lesson lesson : lessons) {
			sumDuration += lesson.duration();
		}
		
		System.out.println();
		System.out.println("DURAÇÃO TOTAL DO CURSO = "+ sumDuration +" segundos");
		
		sc.close();
	}

}
