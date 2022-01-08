package test;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;

import org.junit.jupiter.api.Test;

class PomoTimerPanelTest {

	@Test
	void test() {
		JFrame frame = new JFrame();
		frame.add(new PomoTimerPanel());
	}

}
