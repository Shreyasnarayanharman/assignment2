package com.Harman.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.Harman.model.Details;

@Service
public class StudentService {

	private List<Details> details = new ArrayList<>(Arrays.asList(
			new Details(1,"Shreyas","Mangalore"),
			new Details(2,"Prajwal","Bangalore"),
			new Details(3,"Shwetha","Bangalore")

			)
			);
	public List<Details> getAlldetails() {
		return details;
	}

	public Details getdetail(String tid) {
		Predicate<Details> filterDetails = (details)->{ return details.getName().equals(tid);};

		return	details.stream()
				.filter(
						details -> details.getName().equals(tid))
				.findFirst()
				.get();

	}

	public void addDetail(Details d) {
		details.add(d);
	}

	public void deletedetail(String name) {
		details.removeIf(topic -> topic.getName().equals(name));
	}

}