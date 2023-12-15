package org.example.rest.DTO;


public class RenovationDTO {
	private String name;
	private String height;
	private String width;
	private boolean active;
	private String volume;
	private String field;
	private String lastEditDate;

	@Override
	public String toString() {
		return "\nNazwa: " + name + '\n' +
				"Wysokość: " + height + '\n' +
				"Szerokość: " + width + '\n' +
				"Czy aktywny: " + active + '\n' +
				"Data ostatniej edycji: " + lastEditDate + '\n' +
				"Objętość: " + volume + '\n' +
				"Pole: " + field + '\n';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(String lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String isField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public static class Builder {
		private String name;
		private String height;
		private String width;
		private boolean active;
		private String lastEditDate;
		private String volume;
		private String field;

		public Builder() { }

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setHeight(String height) {
			this.height = height;
			return this;
		}

		public Builder setWidth(String width) {
			this.width = width;
			return this;
		}

		public Builder setActive(boolean active) {
			this.active = active;
			return this;
		}

		public Builder setLastEditDate(String lastEditDate) {
			this.lastEditDate = lastEditDate;
			return this;
		}

		public Builder setVolume(String volume) {
			this.volume = volume;
			return this;
		}

		public Builder setField(String field) {
			this.field = field;
			return this;
		}

		public RenovationDTO build() {
			RenovationDTO renovationDTO = new RenovationDTO();
			renovationDTO.setName(name);
			renovationDTO.setHeight(height);
			renovationDTO.setWidth(width);
			renovationDTO.setActive(active);
			renovationDTO.setLastEditDate(lastEditDate);
			renovationDTO.setVolume(volume);
			renovationDTO.setField(field);
			return renovationDTO;
		}
	}
}
