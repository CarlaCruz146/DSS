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
    ("Carlos Costa","carlos",0,1,1),
    ("Roberto Leal","roberto",1,1,1),
    ("Afonso Martins","afonso",0,1,1),
    ("Mariana Fernandes","mariana",0,1,1),
    ("Margarida Vasconcelos","margarida",1,1,1),
    ("Diana Abreu","diana",0,1,1),
    ("Rodrigo Nunes","rodrigo",0,1,1),
    ("Cláudia Dias","claudia",0,1,1),
    ("Marco Oliveira","marco",0,1,1);

INSERT INTO FuncStand
	(Utilizador)
    VALUES
    ("João Silva"),
    ("Mariana Fernandes"),
	("Rodrigo Nunes");

INSERT INTO FuncFabrica
	(Utilizador)
	VALUES
    ("Carlos Costa"),
    ("Roberto Leal"),
    ("Afonso Martins"),
    ("Margarida Vasconcelos"),
    ("Diana Abreu"),
    ("Cláudia Dias"),
    ("Marco Oliveira");
    
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
    ("123456789","João Delgado","123456789",1),
    ("987654321","Joaquim Costa","987654321",1),
    ("124549802","Arlindo Ramones","124549802",1),
    ("487242891","Rui Ribeiro","487242891",1),
    ("472847284","Bruno Vieira","472847284",1),
    ("109382414","Carolina Costa","109382414",1),
    ("276474181","Guilherme Fontes","276474181",1),
    ("948714193","Paulo Pereira","948714193",1),
    ("126366182","Ricardo Passos","126366182",1),
    ("492482948","Luís Fernandes","492482948",1),
    ("623726718","Diogo Pires","623726718",1),
    ("472827718","Carlota Teixeira","472827718",1),
    ("563526490","Olga Lamego","563526490",1),
    ("173621724","Ester Sousa","173621724",1),
	("428761748","Vitor Fonte","428761748",1);

    
INSERT INTO Encomenda
	(idEncomenda, Estado, Limite, Cliente, Pacote, Fabrica, Carro)
    VALUES
    (1,0,12342,"123456789","Pacote Comfort",1, "Mazda CX-5"),
    (2,0,null,"987654321","Pacote Sport",1, "Seat Ibiza"),
	(3,1,null,"124549802",null,1, "Mercedes Benz"),
    (4,1,null,"487242891",null,1, "Renault Clio"),
    (5,0,35000,"472847284","Pacote Sport",1, "Opel SUV"),
    (6,1,21000,"109382414","Pacote Sport",1, "Opel SUV"),
    (7,0,null,"276474181","Pacote Comfort",1, "Seat Ibiza"),
    (8,0,31000,"948714193","Pacote Comfort",1, "Renault Clio"),
    (9,1,41228,"126366182","Pacote Sport",1, "Seat Ibiza"),
    (10,1,null,"276474181","Pacote Comfort",1, "Mazda CX-5"),
    (11,0,60980,"492482948",null,1, "Seat Ibiza"),
    (12,0,23134,"623726718",null,1, "Opel SUV"),
    (13,1,null,"472827718","Pacote Sport",1, "Seat Ibiza"),
    (14,1,null,"623726718","Pacote Sport",1, "Mercedes Benz"),
    (15,0,48289,"563526490","Pacote Comfort",1, "Seat Ibiza"),
    (16,0,null,"492482948",null,1, "Mercedes Benz"),
    (17,1,null,"173621724","Pacote Comfort",1, "Mazda CX-5"),
    (18,1,78920,"428761748","Pacote Sport",1, "Renault Clio");


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
    (2,"Teto de abrir"),
    (3,"Preto"),
    (3,"D4 190cv Geatronic 8 Vel."),
    (3,"Bridgestone Turanza T005 205/55 R16 91V"),
    (3,"Jantes em liga leve 19'' 255/40 R19"),
    (3,"Couro comfort âmbar"),
    (4,"Branco"),
    (4,"D4 190cv Man. 6 Vel."),
    (4,"Continental ContiEcoContact 5 205/55 R16 91V"),
    (4,"Jantes em liga leve 17''"),
    (4,"Couro comfort maroon brown"),
    (5,"Azul"),
    (5,"D4 190cv Man. 6 Vel."),
    (5,"Bridgestone Turanza T005 205/55 R16 91V"),
    (5,"Jantes em liga leve 18'' 245/45 R18"),
    (5,"Couro comfort âmbar"),
    (6,"Cinzento"),
    (6,"D5 235cv Geatronic 8 Vel."),
    (6,"Continental ContiEcoContact 5 205/55 R16 91V"),
    (6,"Jantes em liga leve 19'' 255/40 R19"),
    (6,"Couro comfort carvão"),
    (7,"Preto"),
    (7,"D4 190cv Geatronic 8 Vel."),
    (7,"Continental ContiEcoContact 5 205/55 R16 91V"),
    (7,"Jantes em liga leve 19'' 255/40 R19"),
    (7,"Couro comfort blond"),
    (8,"Preto"),
    (8,"D5 235cv Geatronic 8 Vel."),
    (8,"Bridgestone Turanza T005 205/55 R16 91V"),
    (8,"Jantes em liga leve 19'' 255/40 R19"),
    (8,"Couro comfort blond"),
    (9,"Cinzento"),
    (9,"D4 190cv Man. 6 Vel."),
    (9,"Firestone Roadhawk 205/55 R16 91H"),
    (9,"Jantes em liga leve 18'' 245/45 R18"),
    (9,"Couro comfort maroon brown"),
    (9,"Pára-choques"),
    (10,"Cinzento"),
    (10,"D4 190cv Geatronic 8 Vel."),
    (10,"Continental ContiEcoContact 5 205/55 R16 91V"),
    (10,"Jantes em liga leve 19'' 255/40 R19"),
    (10,"Couro comfort âmbar"),
	(10,"Pacotes de luz"),
    (10,"Teto de abrir"),
    (11,"Azul"),
    (11,"D4 190cv Man. 6 Vel."),
    (11,"Bridgestone Turanza T005 205/55 R16 91V"),
    (11,"Jantes em liga leve 19'' 255/40 R19"),
    (11,"Couro comfort carvão"),
    (11,"Pacotes de luz"),
    (11,"Teto de abrir"),
    (12,"Branco"),
    (12,"D5 235cv Geatronic 8 Vel."),
    (12,"Continental ContiEcoContact 5 205/55 R16 91V"),
    (12,"Jantes em liga leve 19'' 255/40 R19"),
    (12,"Couro comfort blond"),
    (13,"Branco"),
    (13,"D4 190cv Geatronic 8 Vel."),
    (13,"Firestone Roadhawk 205/55 R16 91H"),
    (13,"Jantes em liga leve 18'' 245/45 R18"),
    (13,"Couro comfort maroon brown"),
    (13,"Pacotes de luz"),
    (13,"Teto de abrir"),
    (14,"Azul"),
    (14,"D4 190cv Geatronic 8 Vel."),
    (14,"Bridgestone Turanza T005 205/55 R16 91V"),
    (14,"Jantes em liga leve 19'' 255/40 R19"),
    (14,"Couro comfort carvão"),    
    (15,"Azul"),
    (15,"D4 190cv Man. 6 Vel."),
    (15,"Firestone Roadhawk 205/55 R16 91H"),
    (15,"Jantes em liga leve 17''"),
    (15,"Couro comfort carvão"),
    (15,"Pára-choques"),
    (16,"Cinzento"),
    (16,"D4 190cv Geatronic 8 Vel."),
    (16,"Bridgestone Turanza T005 205/55 R16 91V"),
    (16,"Jantes em liga leve 18'' 245/45 R18"),
    (16,"Couro comfort blond"),
    (17,"Branco"),
    (17,"D5 235cv Geatronic 8 Vel."),
    (17,"Firestone Roadhawk 205/55 R16 91H"),
    (17,"Jantes em liga leve 19'' 255/40 R19"),
    (17,"Couro comfort blond"),
    (18,"Azul"),
    (18,"D5 235cv Geatronic 8 Vel."),
    (18,"Continental ContiEcoContact 5 205/55 R16 91V"),
    (18,"Jantes em liga leve 17''"),
    (18,"Couro comfort âmbar");


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