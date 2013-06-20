package view;

import com.google.inject.ImplementedBy;

@ImplementedBy(ViewImpl.class)
public interface IView {

	void update();
	GUI getGui();
}
