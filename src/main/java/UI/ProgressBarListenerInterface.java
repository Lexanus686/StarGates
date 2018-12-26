package UI;

import UI.controller.MainPageController;

public interface ProgressBarListenerInterface extends ListenerInterface {
    void update(MainPageController controller, float diff);
}
