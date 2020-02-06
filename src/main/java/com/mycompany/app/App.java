package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {

	// check if [begin, end) subarray is equal
	public boolean checkSubArray(Integer[] arr1, Integer[] arr2, int begin, int end) {
		if (arr1 == null || arr2 == null)
			return false;
		if (arr1.length < end || arr2.length < end)
			return false;
		if (begin < 0 || end < begin)
			return false;
		for (int i = begin; i < end; i++)
			if (arr1[i] != arr2[i])
				return false;
		return true;
	}

	private static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return 4567;
	}

	public static void main(String[] args) {
		port(getHerokuAssignedPort());
		get("/", (req, res) -> "test");
		post("/compute", (req, res) -> {
			String input = req.queryParams("input1");
			java.util.Scanner sc1 = new java.util.Scanner(input);
			sc1.useDelimiter("[;\r\n]+");
			java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
			while (sc1.hasNext()) {
				int value = Integer.parseInt(sc1.next().replaceAll("\\s", ""));
				inputList.add(value);
			}
			Integer[] arr1 = new Integer[inputList.size()];
			for(int i = 0; i < arr1.length; i++)
				arr1[i] = inputList.get(i);
			input = req.queryParams("input2");
			sc1 = new java.util.Scanner(input);
			sc1.useDelimiter("[;\r\n]+");
			inputList = new java.util.ArrayList<>();
			while (sc1.hasNext()) {
				int value = Integer.parseInt(sc1.next().replaceAll("\\s", ""));
				inputList.add(value);
			}
			Integer[] arr2 = new Integer[inputList.size()];
			for(int i = 0; i < arr2.length; i++)
				arr2[i] = inputList.get(i);
			input = req.queryParams("input3").replaceAll("\\s","");
	        int input3AsInt = Integer.parseInt(input);
			input = req.queryParams("input4").replaceAll("\\s","");
	        int input4AsInt = Integer.parseInt(input);
			boolean result = new App().checkSubArray(arr1, arr2, input3AsInt, input4AsInt);
			Map map = new HashMap();
			map.put("result", result);
			return new ModelAndView(map, "compute.mustache");
		}, new MustacheTemplateEngine());
		get("/compute", (rq, rs) -> {
			Map map = new HashMap();
			map.put("result", "not computed yet!");
			return new ModelAndView(map, "compute.mustache");
		}, new MustacheTemplateEngine());
	}

}
