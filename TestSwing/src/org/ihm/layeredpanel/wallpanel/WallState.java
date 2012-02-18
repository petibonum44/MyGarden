package org.ihm.layeredpanel.wallpanel;

public class WallState {

		private Boolean isSelected;
		private Boolean hasFocus;
		public WallState(Boolean isSelected, Boolean hasFocus) {
			super();
			this.isSelected = isSelected;
			this.hasFocus = hasFocus;
		}
		public Boolean getIsSelected() {
			return isSelected;
		}
		public void setIsSelected(Boolean isSelected) {
			this.isSelected = isSelected;
		}
		public Boolean getHasFocus() {
			return hasFocus;
		}
		public void setHasFocus(Boolean hasFocus) {
			this.hasFocus = hasFocus;
		}
		
}
