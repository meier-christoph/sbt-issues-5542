package org.example

import java.nio.charset.StandardCharsets

import org.apache.commons.codec.binary.Hex

object HexNotFound {
  def decode(s: String): String = {
    Hex.encodeHexString(s.getBytes(StandardCharsets.UTF_8))
  }
}
