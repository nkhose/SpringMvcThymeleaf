package com.htmlview;

import java.awt.Desktop;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;

import htmlflow.HtmlView;


public class App {

	/*private static HtmlView<Task> taskDetailsView() {
		HtmlView<Task> taskView = new HtmlView<>();
		taskView.head().title("Task Details")
				.linkCss("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css");
		taskView.body().classAttr("container").heading(1, "Task Details").hr().div().text("Title: ")
				.text(Task::getTitle).br().text("Description: ").text(Task::getDescription).br().text("Priority: ")
				.text(Task::getPriority);
		return taskView;
	}*/

	public static void main(String[] args) throws IOException {
        //
        // Creates and setup an HtmlView object for task details
        //
        HtmlView<?> taskView = new HtmlView<>();
        taskView
                .head()
                .title("Task Details")
                .linkCss("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css");
        taskView
                .body().classAttr("container")
                .heading(1, "Task Details")
                .hr()
                .div()
                .text("Title: ").text("ISEL MPD project")
                .br()
                .text("Description: ").text("A Java library for serializing objects in HTML.")
                .br()
                .text("Priority: ").text("HIGH");
        //
        // Produces an HTML file document
        //
        try(PrintStream out = new PrintStream(new FileOutputStream("Task.html"))){
            taskView.setPrintStream(out).write();
            System.out.println(taskView.toString());
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(URI.create("Task.html"));
            desktop.print(new File("Task.html"));
	}

	}
}

