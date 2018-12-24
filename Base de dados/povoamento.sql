INSERT INTO Fabrica
	(idFabrica)
    VALUES
    (1);
    
INSERT INTO Stand
	(idStand)
    VALUES
    (1);
    
INSERT INTO Utilizador
	(Nome, Password, Stand, Fabrica)
    VALUES
    ("João Silva","joao",1,1),
    ("Carlos Costa","carlos",1,1),
    ("Admin","admin",1,1);

INSERT INTO FuncStand
	(idFuncStand, Utilizador)
    VALUES
    (1,"João Silva");

INSERT INTO FuncFabrica
	(idFuncFabrica, Utilizador)
	VALUES
    (1,"Carlos Costa");
    
INSERT INTO Administrador
	(idAdmin, Utilizador)
    VALUES
    (1,"Admin");
    
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
    
INSERT INTO Componente
	(Nome, Tipo, Preco, Quantidade)
    VALUES
    ("Preto", "Pintura", 1500, 12),
	("Branco", "Pintura", 1200, 10),
	("Cinzento", "Pintura", 1300, 12),
    ("Azul", "Pintura", 1000, 20),

    ("D4 190cv Man. 6 Vel.", "Motor", 3500, 12),
    ("D4 190cv Geatronic 8 Vel.", "Motor", 3700, 15),
    ("D5 235cv Geatronic 8 Vel.", "Motor", 4200, 11),

	("Bridgestone Turanza T005 205/55 R16 91V", "Pneu", 480, 11),
    ("Continental ContiEcoContact 5 205/55 R16 91V", "Pneu", 450, 14),
    ("Continental PremiumContact 6 205/55 R16 91H", "Pneu", 500, 12),
    ("Firestone Roadhawk 205/55 R16 91H", "Pneu", 580, 17),
    
    ("Jantes em liga leve 17''", "Jante", 270, 14),
    ("Jantes em liga leve 18'' 245/45 R18", "Jante", 340, 11),
    ("Jantes em liga leve 19'' 255/40 R19", "Jante", 330, 12),
    
    ("Couro comfort carvão", "Estofo", 1800, 18),
    ("Couro comfort âmbar", "Estofo", 2800, 13),
    ("Couro comfort maroon brown", "Estofo", 3000, 10),
    ("Couro comfort blond", "Estofo", 2600, 16),
    
    ("Pára-choques", "Pára-choque", 270, 9),
    ("Vidro Escurecido", "Vidro", 500, 8),
    ("Teto de abrir", "Teto", 390, 6),
    ("Pacotes de luz", "Luzes", 600, 4),
    
    ("Bancos elétricos", "Pacote", 650, 12),
    ("Ar condicionado de 4 Zonas", "Pacote", 550, 15),
    ("Pacotes de Luzes Interiores", "Pacote", 500, 16),
    ("Espelhos Retrovisores com Mecanismo Anti-Encadeamento", "Pacote", 600, 18),

    ("Jantes personalizadas", "Pacote", 600, 11),
    ("Amortecedores Resistentes", "Pacote", 700, 9),
    ("Spoilers", "Pacote", 1000, 10),
	("Escape com 2 ponteiras", "Pacote", 800, 12);


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
