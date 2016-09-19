package it.unibo.oop.rguis.mvc.view;

public interface CounterView {
	
	void initView();
	
	void updateCounter(int value);
	
	void addCounterViewObserver(CounterViewObserver view);

}
