object Dependencies {
  object Versions {
    val scala211: String = "2.11.12"
    val scala212: String = "2.12.10"
    val scala213: String = "2.13.1"

    val scalaAll: Seq[String] = Seq(scala211, scala212, scala213)

    val scalaForPlay23: Seq[String] = Seq(scala211)
    val scalaForPlay25: Seq[String] = Seq(scala211)
    val scalaForPlay28: Seq[String] = Seq(scala213)

    val play23: String = "2.3.10" // (lts)
    val play25: String = "2.5.19" // (lts)
    val play28: String = "2.8.1"
  }
}
