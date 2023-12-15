package org.example.renovation.model;

public class Renovation {
	private Long id;
	private String name;
	private String dimensions;
	private boolean active;
	private String creationDate;
	private String lastEditDate;
	private String volume;
	private String field;

	private Renovation() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getLastEditDate() {
		return lastEditDate;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public void setLastEditDate(String lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	public static class Builder {
		private Long id;
		private String name;
		private String dimensions;
		private boolean active;
		private String creationDate;
		private String lastEditDate;
		private String volume;
		private String field;

		public Builder() {
		}

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setDimensions(String dimensions) {
			this.dimensions = dimensions;
			return this;
		}

		public Builder setActive(boolean active) {
			this.active = active;
			return this;
		}

		public Builder setCreationDate(String creationDate) {
			this.creationDate = creationDate;
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

		public Renovation build() {
			Renovation renovation = new Renovation();
			renovation.setId(id);
			renovation.setName(name);
			renovation.setDimensions(dimensions);
			renovation.setActive(active);
			renovation.setCreationDate(creationDate);
			renovation.setLastEditDate(lastEditDate);
			renovation.setVolume(volume);
			renovation.setField(field);
			return renovation;
		}
	}
}
