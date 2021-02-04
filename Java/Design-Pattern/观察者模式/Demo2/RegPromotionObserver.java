public class RegPromotionObserver implements RegObserver {
    private PromotionService promotionService;
    @Override
    public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
