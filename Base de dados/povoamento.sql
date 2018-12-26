INSERT INTO Componente
	(Nome, Tipo, Preco)
    VALUES
    ("Preto", "Pintura", 1500),
	("Branco", "Pintura", 1200),
	("Cinzento", "Pintura", 1300),
    ("Azul", "Pintura", 1000),

    ("D4 190cv Man. 6 Vel.", "Motor", 3500),
    ("D4 190cv Geatronic 8 Vel.", "Motor", 3700),
    ("D5 235cv Geatronic 8 Vel.", "Motor", 4200),

	("Bridgestone Turanza T005 205/55 R16 91V", "Pneu", 480),
    ("Continental ContiEcoContact 5 205/55 R16 91V", "Pneu", 450),
    ("Continental PremiumContact 6 205/55 R16 91H", "Pneu", 500),
    ("Firestone Roadhawk 205/55 R16 91H", "Pneu", 580),
    
    ("Jantes em liga leve 17''", "Jante", 270),
    ("Jantes em liga leve 18'' 245/45 R18", "Jante", 340),
    ("Jantes em liga leve 19'' 255/40 R19", "Jante", 330),
    
    ("Couro comfort carvão", "Estofo", 1800),
    ("Couro comfort âmbar", "Estofo", 2800),
    ("Couro comfort maroon brown", "Estofo", 3000),
    ("Couro comfort blond", "Estofo", 2600),
    
    ("Pára-choques", "Pára-choque", 270),
    ("Vidro Escurecido", "Vidro", 500),
    ("Teto de abrir", "Teto", 390),
    ("Pacotes de luz", "Luzes", 600),
    
    ("Bancos elétricos", "Pacote", 650),
    ("Ar condicionado de 4 Zonas", "Pacote", 550),
    ("Pacotes de Luzes Interiores", "Pacote", 500),
    ("Espelhos Retrovisores com Mecanismo Anti-Encadeamento", "Pacote", 600),

    ("Jantes personalizadas", "Pacote", 600),
    ("Amortecedores Resistentes", "Pacote", 700),
    ("Spoilers", "Pacote", 1000),
	("Escape com 2 ponteiras", "Pacote", 800);

INSERT INTO Stock 
	(Quantidade, Componente)
	VALUES    
    (100, "Preto"),
	(150, "Branco"),
	(100, "Cinzento"),
    (100, "Azul"),

    (300, "D4 190cv Man. 6 Vel."),
    (400, "D4 190cv Geatronic 8 Vel."),
    (500, "D5 235cv Geatronic 8 Vel."),

	(400, "Bridgestone Turanza T005 205/55 R16 91V"),
    (500, "Continental ContiEcoContact 5 205/55 R16 91V"),
    (500, "Continental PremiumContact 6 205/55 R16 91H"),
    (600, "Firestone Roadhawk 205/55 R16 91H"),
    
    (1000, "Jantes em liga leve 17''"),
    (1100, "Jantes em liga leve 18'' 245/45 R18"),
    (700, "Jantes em liga leve 19'' 255/40 R19"),
    
    (100, "Couro comfort carvão"),
    (200, "Couro comfort âmbar"),
    (400, "Couro comfort maroon brown"),
    (460, "Couro comfort blond"),
    
    (100, "Pára-choques"),
    (200, "Vidro Escurecido"),
    (300, "Teto de abrir"),
    (500, "Pacotes de luz"),
    
    (450, "Bancos elétricos"),
    (500, "Ar condicionado de 4 Zonas"),
    (600, "Pacotes de Luzes Interiores"),
    (700, "Espelhos Retrovisores com Mecanismo Anti-Encadeamento"),

    (200, "Jantes personalizadas"),
    (400, "Amortecedores Resistentes"),
    (500, "Spoilers"),
	(500,"Escape com 2 ponteiras");

INSERT INTO Fabrica
	(idFabrica, Stock)
    VALUES
        (1, "Preto"),
	(1, "Branco"),
	(1, "Cinzento"),
    (1, "Azul"),

    (1, "D4 190cv Man. 6 Vel."),
    (1, "D4 190cv Geatronic 8 Vel."),
    (1, "D5 235cv Geatronic 8 Vel."),

	(1, "Bridgestone Turanza T005 205/55 R16 91V"),
    (1, "Continental ContiEcoContact 5 205/55 R16 91V"),
    (1, "Continental PremiumContact 6 205/55 R16 91H"),
    (1, "Firestone Roadhawk 205/55 R16 91H"),
    
    (1, "Jantes em liga leve 17''"),
    (1, "Jantes em liga leve 18'' 245/45 R18"),
    (1, "Jantes em liga leve 19'' 255/40 R19"),
    
    (1, "Couro comfort carvão"),
    (1, "Couro comfort âmbar"),
    (1, "Couro comfort maroon brown"),
    (1, "Couro comfort blond"),
    
    (1, "Pára-choques"),
    (1, "Vidro Escurecido"),
    (1, "Teto de abrir"),
    (1, "Pacotes de luz"),
    
    (1, "Bancos elétricos"),
    (1, "Ar condicionado de 4 Zonas"),
    (1, "Pacotes de Luzes Interiores"),
    (1, "Espelhos Retrovisores com Mecanismo Anti-Encadeamento"),

    (1, "Jantes personalizadas"),
    (1, "Amortecedores Resistentes"),
    (1, "Spoilers"),
	(1,"Escape com 2 ponteiras");
    

    
INSERT INTO Stand
	(idStand)
    VALUES
    (1);
    
INSERT INTO Utilizador
	(Nome, Password, Estado, Stand, Fabrica)
    VALUES
    ("João Silva","joao",0,1,1),
    ("Carlos Costa","carlos",0,1,1);

INSERT INTO FuncStand
	(Utilizador)
    VALUES
    ("João Silva");

INSERT INTO FuncFabrica
	(Utilizador)
	VALUES
    ("Carlos Costa");
    
INSERT INTO  Carro
	(Nome, Preco)
    VALUES
    ("Mazda CX-5", 11599),
    ("Seat Ibiza", 12750),
    ("Mercedes Benz", 15480),
    ("Volvo V40", 13300),
    ("Opel SUV", 11990),
    ("Renault Clio", 10270);
    
INSERT INTO Pacote 
	(Nome, Preco)
    VALUES
    ("Pacote Comfort", 1800),
	("Pacote Sport", 2700);


INSERT INTO Cliente
	(Nif,Nome, Contacto, Stand)
    VALUES
    ("123456789","JJ","123456789",1),
    ("987654321","JA","987654321",1);
    
INSERT INTO Encomenda
	(idEncomenda, Estado, Limite, Cliente, Pacote, Fabrica, Carro)
    VALUES
    (1,0,12342,"123456789","Pacote Comfort",1, "Mazda CX-5"),
    (2,0,87457,"987654321","Pacote Sport",1, "Seat Ibiza");


INSERT INTO ComponenteIncompativel
	(Nome, Componente)
	VALUES
    ("D5 235cv Geatronic 8 Vel.","Bridgestone Turanza T005 205/55 R16 91V"),
    ("Bridgestone Turanza T005 205/55 R16 91V","Jantes em liga leve 17''"),
    ("Couro comfort carvão","Bancos elétricos"),
	("Pacotes de luz","Pacotes de Luzes Interiores"),
    ("Bancos elétricos","Couro comfort carvão"),
    ("Pacotes de Luzes Interiores","Espelhos Retrovisores com Mecanismo Anti-Encadeamento");
    
INSERT INTO ComponenteObrigatoria
	(Nome, Componente)
    VALUES
    ("Continental ContiEcoContact 5 205/55 R16 91V","Jantes em liga leve 19'' 255/40 R19");

INSERT Encomenda_Componente
	(Encomenda, Componente)
    VALUES
    (1,"Azul"),
    (1,"D4 190cv Man. 6 Vel."),
    (1,"Firestone Roadhawk 205/55 R16 91H"),
    (1,"Jantes em liga leve 17''"),
    (1,"Couro comfort carvão"),
    (1,"Pára-choques"),
    (2,"Preto"),
    (2,"D4 190cv Geatronic 8 Vel."),
    (2,"Continental ContiEcoContact 5 205/55 R16 91V"),
    (2,"Jantes em liga leve 19'' 255/40 R19"),
    (2,"Couro comfort blond"),
    (2,"Pacotes de luz"),
    (2,"Teto de abrir");

INSERT Pacote_Componente
	(Pacote, Componente)
    VALUES
    ("Pacote Comfort","Bancos elétricos"),
    ("Pacote Comfort","Ar condicionado de 4 Zonas"),
    ("Pacote Comfort","Pacotes de Luzes Interiores"),
    ("Pacote Comfort","Espelhos Retrovisores com Mecanismo Anti-Encadeamento"),
    ("Pacote Sport","Jantes personalizadas"),
    ("Pacote Sport","Amortecedores Resistentes"),
    ("Pacote Sport","Spoilers"),
    ("Pacote Sport","Escape com 2 ponteiras");