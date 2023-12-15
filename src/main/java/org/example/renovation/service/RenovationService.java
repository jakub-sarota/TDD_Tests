package org.example.renovation.service;

import org.example.renovation.model.Renovation;
import org.example.renovation.repository.RenovationRepository;
import org.example.rest.DTO.RenovationDTO;
import org.example.util.ValidateDimension;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RenovationService {
	private static final boolean ACTIVE_ACCOUNT = true;

	public static void showRenovationData() {
		List<Integer> integers = RenovationRepository.showDataByID();
		for(Integer id : integers) {
			System.out.println(id);
		}
	}

	public static RenovationDTO showRenovationData(Integer id) {
		Renovation renovation = RenovationRepository.showDataById(id.longValue());
		String regex = "\\d+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(renovation.getDimensions());

		int value1 = 0;
		int value2 = 0;
		int value3 = 0;

		int index = 0;
		while (matcher.find() && index < 3) {
			int currentValue = Integer.parseInt(matcher.group());
			switch (index) {
				case 0:
					value1 = currentValue;
					break;
				case 1:
					value2 = currentValue;
					break;
				case 2:
					value3 = currentValue;
					break;
			}
			index++;
		}

		return new RenovationDTO.Builder()
				.setName(renovation.getName())
				.setHeight(Integer.toString(value1))
				.setWidth(Integer.toString(value2))
				.setLength(Integer.toString(value3))
				.setActive(renovation.isActive())
				.setLastEditDate(renovation.getLastEditDate().toString())
				.setVolume(renovation.getVolume())
				.setField(renovation.getField())
				.build();
	}

	public static Renovation addRenovation(RenovationDTO renovationDTO) {
		if (!validateRenovationDTO(renovationDTO)) {
			Renovation renovation = new Renovation.Builder()
				.setName(renovationDTO.getName())
				.setDimensions(parseDimensions(renovationDTO))
				.setActive(ACTIVE_ACCOUNT)
				.build();
			Long renovation1 = RenovationRepository.addRenovation(renovation).getId();
			if (!renovation1.toString().isEmpty()) {
				System.out.println("\nUtworzono obiekt do renowacji o id: " + renovation1);
			}
		}

		return new Renovation.Builder().build();
	}

	private static boolean validateRenovationDTO(RenovationDTO renovationDTO) {
		return renovationDTO.getName().isBlank() && renovationDTO.getName() == null &&
				renovationDTO.getWidth().isBlank() && renovationDTO.getWidth() == null &&
				renovationDTO.getLength().isBlank() && renovationDTO.getLength() == null &&
				renovationDTO.getHeight().isBlank() && renovationDTO.getHeight() == null;
	}

	private static String parseDimensions(RenovationDTO renovationDTO) {
		String dimensions = "";
		if (validateDimension(renovationDTO.getHeight()) && validateDimension(renovationDTO.getWidth())) {
			dimensions = renovationDTO.getWidth() + " |/ " + renovationDTO.getHeight();
			if (validateDimension(renovationDTO.getLength())) {
				return dimensions + " || " + renovationDTO.getLength();
			}
			return dimensions;
		}

		return dimensions;
	}

	private static boolean validateDimension(String value) {
		return ValidateDimension.validateDimension(value);
	}
}
