package com.pasindu.plantit;

public class diseasedetection {
    public String diagnoseDisease(byte[] imageData, String language) {
        if (language.equals("en")) {
            return "Disease: Leaf Spot\nDescription: Fungal spots on leaves.\nTreatment: Apply antifungal spray.";
        } else {
            return "Enfermedad: Manchas en hojas\nDescripción: Manchas fúngicas.\nTratamiento: Use fungicida.";
        }
    }
}
