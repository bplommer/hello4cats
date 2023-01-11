package io.github.bplommer.hello4cats

import cats.effect.Sync
import cats.effect.std.Console

trait Greeter[F[_]] {
  def sayHello: F[Unit]
}

object Greeter {
  def make[F[_]: Sync]: Greeter[F] = new Greeter[F] {
    def sayHello: F[Unit] = Console.make[F].println("hello world!")
  }
}
