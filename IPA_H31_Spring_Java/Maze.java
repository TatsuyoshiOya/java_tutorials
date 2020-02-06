public class Maze {
  private final String mazeData;
  private final int width;
  private final Location startLocation;

  public Maze(String mazeData, int width) {
    this.mazeData = mazeData;
    this.width = width;
    startLocation = locationOf('S');
  }

  public Location getStartLocation() {
    return startLocation;
  }

  public boolean isGoal(Location loc) {
    // 回答aの答え *
    return mazeData.charAt(loc.y  * width + loc.x) == 'G';
  }
  public boolean isBlank(Location loc) {
    // 回答aの答え *
    return mazeData.charAt(loc.y * width + loc.x) != '*';
  }

  private Location locationOf(char c) {
    int index = mazeData.indexOf(c);
    // 回答bの答え %
    return new Location(index % width, index / width);
  }
}
