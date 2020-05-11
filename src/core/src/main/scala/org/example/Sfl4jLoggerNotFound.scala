package org.example

import org.slf4j.{Logger, LoggerFactory}

object Sfl4jLoggerNotFound {
  val logger: Logger = LoggerFactory.getLogger(getClass)

  def foo(): Unit = {
    logger.debug("test")
  }
}
