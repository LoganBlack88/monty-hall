import org.github.loganblack88.montyhall.Game
import org.github.loganblack88.montyhall.Strategy
import org.github.loganblack88.montyhall.strategies.ChangePickStrategy
import org.github.loganblack88.montyhall.strategies.KeepPickStrategy


fun main() {

    val PLAYS       = 1000
    val KEEP_PICK   = KeepPickStrategy()
    val CHANGE_PICK = ChangePickStrategy()

    var keepWins = playStrategy(KEEP_PICK, PLAYS)
    var changeWins = playStrategy(CHANGE_PICK, PLAYS);

    println("--------------------------------------------------------------------------")
    println("Experiment Results")
    println("Games won with strategy '${KEEP_PICK.description}'   : ${keepWins} / ${PLAYS}")
    println("Games won with strategy '${CHANGE_PICK.description}' : ${changeWins} / ${PLAYS}")

}


/**
 * Play the game with a provided strategy a provided number of times, and return the numbers of wins.
 */
fun playStrategy(strategy: Strategy, games: Int): Int {
    var wins = 0
    for (i in 1..games) {
        val won = Game().play(strategy)
        if (won) {
            wins++
        }
    }
    return wins
}