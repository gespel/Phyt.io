class PumpController {
public:
    PumpController();
    void togglePump(int pumpNr);
private:
    bool pumpState1 = true;
    bool pumpState2 = true;
    bool pumpState3 = true;
};

PumpController::PumpController() {
    
}

void PumpController::togglePump(int pumpNr) {
    switch(pumpNr) {
        case 0:
            pumpState1 = !pumpState1;
            break;
        case 1:
            pumpState2 = !pumpState2;
            break;
        case 2:
            pumpState3 = !pumpState3;
            break;
    }

    if(pumpState1 == true) {
        digitalWrite(25, HIGH);
    }
    else {
        digitalWrite(25, LOW);
    }
    if(pumpState2 == true) {
        digitalWrite(26, HIGH);
    }
    else {
        digitalWrite(26, LOW);
    }
    if(pumpState3 == true) {
        digitalWrite(27, HIGH);
    }
    else {
        digitalWrite(27, LOW);
    }
}