package br.com.ourtrip.app.repository

import br.com.ourtrip.app.model.Destination
import kotlinx.coroutines.delay

suspend fun getAllDestinations(): List<Destination> {
    delay(timeMillis = 5000)
    return listOf(
        Destination(
            id = 0,
            destinationName = "Parque Serenity",
            imageUrl = "https://plus.unsplash.com/premium_photo-1687354995641-716a8869d6fc?q=80&w=1287&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            starNumber = "3.5",
            destinationPrice = "15,0",
            description = "o Parque Serenity é um refúgio encantador, onde a natureza se encontra com o lazer, proporcionando uma escapada revitalizante para todas as idades."
        ),
        Destination(
            id = 1,
            destinationName = "Jardim das Flores",
            imageUrl = "https://images.unsplash.com/photo-1567373371655-21459285e270?q=80&w=1286&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            starNumber = "4.2",
            destinationPrice = "10,0",
            description = "O Jardim das Flores é um paraíso botânico, onde visitantes podem se maravilhar com uma vasta coleção de flores de todas as cores e tamanhos, criando um cenário de beleza incomparável."
        ),
        Destination(
            id = 2,
            destinationName = "Trilhas da Montanha",
            imageUrl = "https://images.unsplash.com/photo-1564946623240-66e7239a2594?q=80&w=1287&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            starNumber = "4.8",
            destinationPrice = "26,50",
            description = "As Trilhas da Montanha oferecem aventura e desafio para os amantes da natureza, com paisagens deslumbrantes, riachos cristalinos e fauna diversificada esperando para serem explorados."
        ),
        Destination(
            id = 3,
            destinationName = "Praia do Sol",
            imageUrl = "https://images.unsplash.com/photo-1609144514140-f8e5857feef7?q=80&w=1035&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            starNumber = "4.5",
            destinationPrice = "0,0",
            description = "A Praia do Sol é um paraíso à beira-mar, com areias douradas, águas cristalinas e uma atmosfera relaxante, ideal para dias ensolarados e momentos de descontração."
        ),
        Destination(
            id = 4,
            destinationName = "Lago Sereno",
            imageUrl = "https://images.unsplash.com/photo-1559310589-2673bfe16970?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            starNumber = "4.0",
            destinationPrice = "30,0",
            description = "O Lago Sereno oferece serenidade e paz, com águas tranquilas cercadas por colinas verdes e árvores majestosas, proporcionando um refúgio perfeito para relaxar e descontrair."
        ),
        Destination(
            id = 5,
            destinationName = "Mirante do Horizonte",
            imageUrl = "https://images.unsplash.com/photo-1609281238116-045440313258?q=80&w=1288&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            starNumber = "4.6",
            destinationPrice = "50,0",
            description = "O Mirante do Horizonte oferece vistas panorâmicas deslumbrantes da paisagem circundante, permitindo que os visitantes contemplem a vastidão da natureza em todo o seu esplendor."
        ),
        Destination(
            id = 6,
            destinationName = "Cachoeira da Paz",
            imageUrl = "https://images.unsplash.com/photo-1519582149095-fe7d19b2a3d2?q=80&w=1309&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            starNumber = "4.3",
            destinationPrice = "25,0",
            description = "A Cachoeira da Paz é um espetáculo natural magnífico, onde a água cristalina cai em cascata entre rochas e vegetação exuberante, criando uma atmosfera de serenidade e admiração."
        )
    )
}