package com.example.petapp;

public class DadosCompartilhados {

    public static String usuarioLogado;

    public static String[] usuarios ={"admin","pedro","marcelo","maria","joana"};
    public static String[] senhas ={"123","678","1234","9098","00043"};

    public static int IND_VETOR_PET = 0;
    public static final int TAM_MAX_VETOR_PET = 50;
    public static Pet[] vetorPets = new Pet[TAM_MAX_VETOR_PET];

    public static boolean salvarPet(String nome,String idade){
        if(IND_VETOR_PET >= TAM_MAX_VETOR_PET){
            return false;
        }
        Pet pet = new Pet();
        pet.nome = nome;
        pet.idade = idade;
        vetorPets[IND_VETOR_PET] = pet;
        IND_VETOR_PET++;
        return true;
    }

    public static boolean atualizarIdadePet(String nome, String novaIdade){
        for(int i = 0; i < IND_VETOR_PET; i++){
            if(vetorPets[i].nome.equalsIgnoreCase(nome)){
                vetorPets[i].idade = novaIdade;
                return true;
            }
        }
        return false;
    }

    public static boolean removerPet(String nome){
        for(int i = 0; i < IND_VETOR_PET; i++){
            if(vetorPets[i].nome.equalsIgnoreCase(nome)){
                for(int j = i; j < IND_VETOR_PET - 1; j++){
                    vetorPets[j] = vetorPets[j + 1];
                }
                vetorPets[IND_VETOR_PET - 1] = null;
                IND_VETOR_PET--;
                return true;
            }
        }
        return false;
    }
}
