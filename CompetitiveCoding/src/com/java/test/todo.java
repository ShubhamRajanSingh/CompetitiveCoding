package com.java.test;

import java.util.prefs.*;
import java.time.LocalDate;

public class todo {

	public static String list_length = "list_length";
	public static String done = "done";

	public static void main(String[] args) {
		if (args.length == 0 || args[0].equals("help") )
			help();
		else if (args[0].equals("add"))
			add(args[1]);
		else if (args[0].equals("ls"))
			ls();
		else if (args[0].equals("del"))
			del(Integer.parseInt(args[1]));
		else if (args[0].equals("done"))
			done(Integer.parseInt(args[1]));
		else if (args[0].equals("report"))
			report();

	}

	public static void report() {
		Preferences prefs = Preferences.userNodeForPackage(todo.class);
		LocalDate date = LocalDate.now();
		int n = prefs.getInt(list_length, 0);
		int m = prefs.getInt(done, 0);
		System.out.println(date + "   " + "Pending : " + n + "  Completed : " + m);

	}

	public static void ls() {
		Preferences prefs = Preferences.userNodeForPackage(todo.class);
		int n = prefs.getInt(list_length, 0);
		if (n != 0) {
			for (int i = 1; i <= n; i++) {

				System.out.println("[" + i + "] " + prefs.get("todo_" + i, "default"));

			}
		}

	}

	public static void done(int n) {
		Preferences prefs = Preferences.userNodeForPackage(todo.class);
		int m = prefs.getInt(done, 0);
		m = m + 1;
		prefs.putInt(done, m);
		del(n);
		System.out.println("Marked todo #" + n + " as done.");

	}

	public static void del(int n) {
		Preferences prefs = Preferences.userNodeForPackage(todo.class);
		int m = prefs.getInt(list_length, 0);
		if (n > m) {
			System.out.println("Task doesn't exist");
			return;
		}

		while (n != m + 1) {
			String s = prefs.get("todo_" + n, "default");
			prefs.put("todo_" + n, s);
			n++;

		}
		prefs.remove("todo_" + m);

		m = m - 1;
		prefs.putInt(list_length, m);

	}

	public static void help() {

		System.out.println(
				"Usage:-\njava todo.java add 'todo item'\t# Add a new todo \njava todo.java ls\t\t# Show remaining todos\njava todo.java del NUMBER\t# Delete a todo\njava todo.java done NUMBER\t# Complete a todo\njava todo.java help\t\t# Show Usage \njava todo.java report\t\t# Statistics");

	}

	public static void add(String s) {

		Preferences prefs = Preferences.userNodeForPackage(todo.class);

		int n = prefs.getInt(list_length, 0);
		if (n == 0) {
			prefs.putInt(list_length, 1);
			n = n + 1;
			prefs.put("todo_" + n, s);
		} else {
			n = n + 1;
			prefs.putInt(list_length, n);
			prefs.put("todo_" + n, s);
		}

		System.out.println("Added todo : " + s);

	}

}
