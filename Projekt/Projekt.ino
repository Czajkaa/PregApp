#include <ESP8266WiFi.h>
#include <FirebaseESP8266.h>
#include <math.h>
#include <Wire.h>
#include <Adafruit_MLX90614.h>

#define FIREBASE_HOST ""
#define FIREBASE_AUTH ""
#define WIFI_SSID ""
#define WIFI_PASSWORD ""
FirebaseData firebaseData;
Adafruit_MLX90614 mlx = Adafruit_MLX90614();
double temp1 = 0.0;
int temp2 = 0;
String nazwa = "";
int temp_status = 0;
int number = 0;
double sum = 0;

void setup() {
  pinMode(12, OUTPUT);
  pinMode(13, OUTPUT);
  
  Serial.begin(115200);
  while (!Serial);

  if (!mlx.begin()) {
    Serial.println("Error connecting to MLX sensor. Check wiring.");
    while (1);
  };
  
  Serial.println("Serial communication started\n\n");            
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting to ");
  Serial.print(WIFI_SSID);

  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(500);
  }

  Serial.println();
  Serial.print("Connected to ");
  Serial.println(WIFI_SSID);
  Serial.print("IP Address is : ");
  Serial.println(WiFi.localIP());
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  Firebase.reconnectWiFi(true);
  delay(1000);
}

void loop() {
  if (Firebase.getInt(firebaseData, "UserID/3e7497a39efbd48978b8f6f928606789/Measurement/Temperature/Status")){
    if (firebaseData.dataType() == "int") {
      temp_status = (firebaseData.intData());
    }
  }
  Serial.println(temp_status);
  
  while(temp_status == 1) {
    for(int j=1; j<=10; j++) {
      Serial.print(mlx.readAmbientTempC());
      Serial.print(mlx.readObjectTempC());
      Serial.print(mlx.readAmbientTempF());
      Serial.println(mlx.readObjectTempF());
    
      temp1 = mlx.readObjectTempC()+3.0;
      temp2 = round(temp1);
      temp1 = temp2+round((temp1-temp2)*10)/10;
      Serial.println(temp1);
      if(temp1 > 30) {
        sum = sum+temp1;
        digitalWrite(13, LOW);
        digitalWrite(12, HIGH);
      } else {
        j = j-1;
        digitalWrite(13, HIGH);
      }
      Serial.println(sum);
      Serial.println(j);
      delay(500);
      digitalWrite(12, LOW);
      delay(500);
    }
    sum = sum/10;

    if (Firebase.getInt(firebaseData, "UserID/3e7497a39efbd48978b8f6f928606789/Measurement/Temperature/Number")){
      if (firebaseData.dataType() == "int") {
        number = (firebaseData.intData());
      }
    }
    
    String number1 = String(number+1);
    nazwa = String("UserID/3e7497a39efbd48978b8f6f928606789/Measurement/Temperature/Values/" + number1);
    Firebase.setInt(firebaseData, nazwa, sum);
    sum = 0;
    Firebase.setInt(firebaseData, "UserID/3e7497a39efbd48978b8f6f928606789/Measurement/Temperature/Status", 0);
    Firebase.setInt(firebaseData, "UserID/3e7497a39efbd48978b8f6f928606789/Measurement/Temperature/Number", number+1);
    digitalWrite(12, LOW);
    digitalWrite(13, LOW);
    break;
  }
}
