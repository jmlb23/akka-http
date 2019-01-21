package com.github.jmlb23.textshare.domain

import java.time.LocalDateTime



final case class User(id: Long, username: String, dateRegistered: LocalDateTime, texts: List[Text])

final case class Text(id: Long, name: String, content: String, format: String, owner: User)

