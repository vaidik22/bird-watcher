import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return new int[]{0, 2, 5, 3, 7, 8, 4};
    }

    public int getToday() {

        if (birdsPerDay.length == 0) {
            return 0;
        }
        return birdsPerDay.length == 0 ? 0 : birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        if (birdsPerDay.length == 0) {
            return;
        }
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        return Arrays.stream(birdsPerDay).anyMatch(birdsCount -> birdsCount == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
        return Arrays.stream(birdsPerDay).limit(numberOfDays).sum();
    }

    public int getBusyDays() {
        return (int) Arrays.stream(birdsPerDay).filter(day -> day >= 5).count();
    }
}
