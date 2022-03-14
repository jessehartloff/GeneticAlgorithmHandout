package music

import music.Music._

import scala.io.Source

object Music {


  // TODO: Implement required methods as defined in the HW Doc



  /**
   * You may use this helper method to read a file and return a List of Strings containing the lines of the file
   *
   * @param filename The file to be read
   * @return The lines of the file as a List of Strings with 1 String per line
   */
  def filenameToListOfLines(filename: String): List[String] = {
    val file = Source.fromFile(filename)
    val lines: List[String] = file.getLines().toList
    file.close()
    lines
  }

  // TODO: Uncomment after implementing the required methods
  // Uses your methods to read all the data in a file with song ratings
  //  def readSongsFromFile(filename: String): List[Song] = {
  //    val songsWithDuplicates: List[Song] = readSongsFromFileWithoutDuplicates(filename)
  //    val songMap: Map[String, Song] = songListToMap(songsWithDuplicates)
  //    songMap.values.toList
  //  }

  // Can be used to test your application objective
  def songIncubator(songs: List[Song]): List[Double] => Song = {
    genes: List[Double] => {
      val geneSong: Int = (genes.head.abs * songs.length).toInt % songs.length
      songs(geneSong)
    }
  }

  // Can be used to test your application objective
  def playlistIncubator(songs: List[Song]): List[Double] => Playlist = {
    genes: List[Double] => {
      val incubatorForSongs: List[Double] => Song = songIncubator(songs)
      new Playlist(genes.map((gene: Double) => incubatorForSongs(List(gene))))
    }
  }

}






