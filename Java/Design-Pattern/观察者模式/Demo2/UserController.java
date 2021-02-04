import java.util.ArrayList;
import java.util.List;

public class UserController {
    private UserService userService;
    private List<RegObserver> regObservers = new ArrayList<>();

    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }

    public Long register(String telephone, String password) {
        long userId = userService.register(telephone, password);
        for (RegObserver observer : regObservers) {
            observer.handleRegSuccess(userId);
        }
        return userId;
    }

}
