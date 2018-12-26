package UI;

import UI.controller.MainPageController;

public class ProgressBarListener implements ProgressBarListenerInterface {
    private float percentage = 0;

    @Override
    public void update(MainPageController controller, float diff) {
        percentage += diff;
        controller.updateProgressBar(percentage);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

    }
}
