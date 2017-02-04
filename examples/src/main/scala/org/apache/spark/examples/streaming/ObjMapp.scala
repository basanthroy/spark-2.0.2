package org.apache.spark.examples.streaming


import java.util.Random

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}

//import com.fasterxml.jackson.module.
//import com.fasterxml.jackson.module.scala
import com.fasterxml.jackson.module.scala.DefaultScalaModule

//case class Person(@JsonProperty("FName") FName: String, @JsonProperty("LName") LName: String)
case class Person(FName: String, LName: String)

object ObjMapp {

  def main(args: Array[String]) {
    var value:String = """{"FName":"Mad", "LName": "Max"}"""
    val objectMapper: ObjectMapper = new ObjectMapper()
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    objectMapper.registerModule(DefaultScalaModule)
    val jsonObject:Person = objectMapper
      .readValue(value, classOf[Person])
    println("jsonobject" + jsonObject)
    println("string value" + objectMapper.writeValueAsString(jsonObject))
  }

}

