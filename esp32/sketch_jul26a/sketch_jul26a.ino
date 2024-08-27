#include <WebServer.h>
#include <WiFi.h>
#include "pumpcontroller.h"
#include "stens_moisture_sensor.h"

const char* ssid = "MagentaWLAN-RT6R";
const char* password = "stenistderking";

WebServer server(80);
StensMoistureSensor sms("prototyp");
PumpController pc;

void setup() {
  pinMode(32, INPUT);
  pinMode(25, OUTPUT);
  pinMode(26, OUTPUT);
  pinMode(27, OUTPUT);
  digitalWrite(25, HIGH);
  digitalWrite(26, HIGH);
  digitalWrite(27, HIGH);
  Serial.begin(9600);
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected.");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
  server.on("/", handle_root);
  server.on("/json", handle_json);
  server.on("/pump1", handle_pump1);
  server.on("/pump2", handle_pump2);
  server.on("/pump3", handle_pump3);
  server.begin();
}

void loop() {
  server.handleClient();
  
  Serial.println(sms.getRaw());
  delay(500);
}

void handle_root() {
  String out = sms.getHTML();
  server.send(200, "text/html", out);
}

void handle_json() {
  String out = sms.getJson();
  server.send(200, "application/json", out);
}

void handle_pump1() {
    pc.togglePump(0);
    server.send(200, "text/html", "Ok");
}
void handle_pump2() {
    pc.togglePump(1);
    server.send(200, "text/html", "Ok");
}
void handle_pump3() {
    pc.togglePump(2);
    server.send(200, "text/html", "Ok");
}
