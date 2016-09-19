public class CustomizeJourGeek ... {

  ...
  
  private static final String BASE_PATH = "/images/geek/geek-";
  
  private void updatePicture() {
    //Get the icon corresponding to the image.
    ImageIcon icon = null;
    String imgPath = BASE_PATH + choices.toString() + IMAGE_EXTENSION;
    /* loading the image from the class */
    URL imgURL =  UseCheckBox.class.getResource(
	                             BASE_PATH+ choices.toString() 
		                         + IMAGE_EXTENSION);
    if (imgURL != null) {
      icon = new ImageIcon(imgURL);
      pictureLabel.setIcon(icon);
      pictureLabel.setText(null);
    } else {
      System.err.println("Couldn't find file: " + imgPath);
      pictureLabel.setText("Missing Image");
}}}