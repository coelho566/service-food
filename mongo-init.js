print('Start #################################################################');

db = connect("mongodb://admin:admin@localhost:27017");

const database = 'db-food';
const crientCollection = 'Client';
const productCollection = 'Product';
const orderCollection = 'Order';

db = db.getSiblingDB(database); // Seleciona o banco de dados 'mydatabase'
db.createCollection(crientCollection);
db.createCollection(productCollection);
db.createCollection(orderCollection);

db.Product.insertMany([
    {
        "id": "1",
        "name": "Cheeseburger",
        "description": "Um delicioso cheeseburger com carne, queijo cheddar, alface e tomate.",
        "category": "Lanche",
        "price": 15.99,
        "image": "/images/cheeseburger.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["carne", "queijo cheddar", "alface", "tomate", "pão de hambúrguer"],
        "breadType": "Pão de hambúrguer",
        "weight": 250,
        "calories": 500
    },
    {
        "id": "2",
        "name": "Sanduíche de Frango",
        "description": "Sanduíche de frango crocante com alface e maionese.",
        "category": "Lanche",
        "price": 12.99,
        "image": "/images/chickenSandwich.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["frango", "alface", "maionese", "pão de hambúrguer"],
        "breadType": "Pão de hambúrguer",
        "weight": 230,
        "calories": 450
    },
    {
        "id": "3",
        "name": "Veggie Burger",
        "description": "Um saudável veggie burger com alface, tomate e abacate.",
        "category": "Lanche",
        "price": 13.99,
        "image": "/images/veggieBurger.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["hambúrguer vegetal", "alface", "tomate", "abacate", "pão de hambúrguer"],
        "breadType": "Pão de hambúrguer",
        "weight": 200,
        "calories": 400
    },
    {
        "id": "4",
        "name": "Bacon Burger",
        "description": "Hambúrguer suculento com bacon, queijo cheddar e molho barbecue.",
        "category": "Lanche",
        "price": 17.99,
        "image": "/images/baconBurger.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["carne", "bacon", "queijo cheddar", "molho barbecue", "pão de hambúrguer"],
        "breadType": "Pão de hambúrguer",
        "weight": 270,
        "calories": 550
    },
    {
        "id": "5",
        "name": "Fish Burger",
        "description": "Hambúrguer de filé de peixe com molho tártaro e alface.",
        "category": "Lanche",
        "price": 14.99,
        "image": "/images/fishBurger.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["filé de peixe", "molho tártaro", "alface", "pão de hambúrguer"],
        "breadType": "Pão de hambúrguer",
        "weight": 220,
        "calories": 430
    },
    {
        "id": "6",
        "name": "Batata Frita",
        "description": "Batatas fritas douradas e crocantes.",
        "category": "Acompanhamento",
        "price": 4.99,
        "image": "/images/fries.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["batata", "sal"],
        "portionSize": "Média",
        "weight": 150,
        "calories": 300
    },
    {
        "id": "7",
        "name": "Anéis de Cebola",
        "description": "Anéis de cebola crocantes.",
        "category": "Acompanhamento",
        "price": 5.99,
        "image": "/images/onionRings.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["cebola", "massa", "sal"],
        "portionSize": "Média",
        "weight": 180,
        "calories": 350
    },
    {
        "id": "8",
        "name": "Coleslaw",
        "description": "Salada de repolho fresca com molho azedo.",
        "category": "Acompanhamento",
        "price": 3.99,
        "image": "/images/coleslaw.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["repolho", "cenoura", "molho"],
        "portionSize": "small",
        "weight": 100,
        "calories": 200
    },
    {
        "id": "9",
        "name": "Palitos de Mozzarella",
        "description": "Palitos de mozzarella fritos com molho marinara.",
        "category": "Acompanhamento",
        "price": 6.99,
        "image": "/images/mozzarellaSticks.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["queijo mozzarella", "massa", "molho marinara"],
        "portionSize": "Média",
        "weight": 200,
        "calories": 400
    },
    {
        "id": "10",
        "name": "Batata Doce Frita",
        "description": "Batata doce frita com um toque de canela.",
        "category": "Acompanhamento",
        "price": 5.49,
        "image": "/images/sweetPotatoFries.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["batata doce", "canela", "sal"],
        "portionSize": "Média",
        "weight": 160,
        "calories": 320
    },
    {
        "id": "11",
        "name": "Bolo de Chocolate",
        "description": "Bolo de chocolate rico com cobertura de chocolate.",
        "category": "Sobremesa",
        "price": 6.99,
        "image": "/images/chocolateCake.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["chocolate", "farinha", "açúcar", "ovos", "manteiga"],
        "dessertType": "Bolo",
        "weight": 150,
        "calories": 350
    },
    {
        "id": "12",
        "name": "Sorvete",
        "description": "Sorvete de baunilha com gotas de chocolate.",
        "category": "Sobremesa",
        "price": 4.99,
        "image": "/images/iceCream.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["leite", "açúcar", "baunilha", "gotas de chocolate"],
        "dessertType": "Sorvete",
        "weight": 100,
        "calories": 200
    },
    {
        "id": "13",
        "name": "Torta de Maçã",
        "description": "Torta de maçã clássica com uma crosta crocante.",
        "category": "Sobremesa",
        "price": 5.99,
        "image": "/images/applePie.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["maçãs", "farinha", "açúcar", "manteiga", "canela"],
        "dessertType": "Torta",
        "weight": 180,
        "calories": 300
    },
    {
        "id": "14",
        "name": "Brownie",
        "description": "Brownie macio com nozes.",
        "category": "Sobremesa",
        "price": 3.99,
        "image": "/images/brownie.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["chocolate", "farinha", "açúcar", "ovos", "manteiga", "nozes"],
        "dessertType": "Brownie",
        "weight": 120,
        "calories": 280
    },
    {
        "id": "15",
        "name": "Refrigerante",
        "description": "Refrigerante gelado de diversos sabores.",
        "category": "Bebida",
        "price": 2.99,
        "image": "/images/soda.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["água", "açúcar", "gás carbônico", "sabores artificiais"],
        "drinkType": "Refrigerante",
        "volume": 500,
        "calories": 150
    },
    {
        "id": "16",
        "name": "Suco de Laranja",
        "description": "Suco de laranja natural e fresco.",
        "category": "Bebida",
        "price": 3.99,
        "image": "/images/orangeJuice.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["laranja"],
        "drinkType": "Suco",
        "volume": 300,
        "calories": 120
    },
    {
        "id": "17",
        "name": "Água Mineral",
        "description": "Água mineral pura e refrescante.",
        "category": "Bebida",
        "price": 1.99,
        "image": "/images/water.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["água mineral"],
        "drinkType": "Agua",
        "volume": 500,
        "calories": 0
    },
    {
        "id": "18",
        "name": "Milkshake de Morango",
        "description": "Milkshake cremoso de morango com chantilly.",
        "category": "Bebida",
        "price": 5.99,
        "image": "/images/strawberryMilkshake.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["leite", "sorvete de morango", "chantilly"],
        "drinkType": "MilkShak",
        "volume": 400,
        "calories": 350
    },
    {
        "id": "19",
        "name": "Chá Gelado",
        "description": "Chá gelado de limão com hortelã.",
        "category": "Bebida",
        "price": 3.49,
        "image": "/images/icedTea.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["água", "chá", "limão", "hortelã"],
        "drinkType": "Chá",
        "volume": 350,
        "calories": 80
    },
    {
        "id": "20",
        "name": "Café",
        "description": "Café quente e forte.",
        "category": "Bebida",
        "price": 2.49,
        "image": "/images/coffee.jpg",
        "availability": true,
        "dateAdded": new Date("2024-05-25T00:00:00Z"),
        "ingredients": ["água", "café"],
        "drinkType": "Café",
        "volume": 250,
        "calories": 5
    }
]);

db.Client.insertMany(
    [
        {
            "name": "Alice Johnson",
            "phone": "123-456-7890",
            "email": "alice.johnson@example.com",
            "document": "12345678901",
            "documentType": "CPF",
            "allowNotification": true,
            "address": {
                "postalCode": "12345-678",
                "street": "Rua A",
                "state": "SP",
                "city": "São Paulo",
                "number": "100"
            }
        },
        {
            "name": "Bob Smith",
            "phone": "987-654-3210",
            "email": "bob.smith@example.com",
            "document": "98765432100",
            "documentType": "CPF",
            "allowNotification": false,
            "address": {
                "postalCode": "23456-789",
                "street": "Rua B",
                "state": "RJ",
                "city": "Rio de Janeiro",
                "number": "200"
            }
        },
        {
            "name": "Carol Williams",
            "phone": "555-666-7777",
            "email": "carol.williams@example.com",
            "document": "11122233344",
            "documentType": "CPF",
            "allowNotification": true,
            "address": {
                "postalCode": "34567-890",
                "street": "Rua C",
                "state": "MG",
                "city": "Belo Horizonte",
                "number": "300"
            }
        },
        {
            "name": "David Brown",
            "phone": "444-555-6666",
            "email": "david.brown@example.com",
            "document": "44455566677",
            "documentType": "CPF",
            "allowNotification": false,
            "address": {
                "postalCode": "45678-901",
                "street": "Rua D",
                "state": "RS",
                "city": "Porto Alegre",
                "number": "400"
            }
        },
        {
            "name": "Emily Davis",
            "phone": "333-444-5555",
            "email": "emily.davis@example.com",
            "document": "55566677788",
            "documentType": "CPF",
            "allowNotification": true,
            "address": {
                "postalCode": "56789-012",
                "street": "Rua E",
                "state": "PR",
                "city": "Curitiba",
                "number": "500"
            }
        },
        {
            "name": "Frank Wilson",
            "phone": "222-333-4444",
            "email": "frank.wilson@example.com",
            "document": "66677788899",
            "documentType": "CPF",
            "allowNotification": false,
            "address": {
                "postalCode": "67890-123",
                "street": "Rua F",
                "state": "SC",
                "city": "Florianópolis",
                "number": "600"
            }
        },
        {
            "name": "Grace Miller",
            "phone": "111-222-3333",
            "email": "grace.miller@example.com",
            "document": "77788899900",
            "documentType": "CPF",
            "allowNotification": true,
            "address": {
                "postalCode": "78901-234",
                "street": "Rua G",
                "state": "BA",
                "city": "Salvador",
                "number": "700"
            }
        },
        {
            "name": "Henry Moore",
            "phone": "000-111-2222",
            "email": "henry.moore@example.com",
            "document": "88899900011",
            "documentType": "CPF",
            "allowNotification": false,
            "address": {
                "postalCode": "89012-345",
                "street": "Rua H",
                "state": "CE",
                "city": "Fortaleza",
                "number": "800"
            }
        },
        {
            "name": "Ivy Taylor",
            "phone": "999-888-7777",
            "email": "ivy.taylor@example.com",
            "document": "99900011122",
            "documentType": "CPF",
            "allowNotification": true,
            "address": {
                "postalCode": "90123-456",
                "street": "Rua I",
                "state": "PE",
                "city": "Recife",
                "number": "900"
            }
        },
        {
            "name": "Jack Martinez",
            "phone": "888-777-6666",
            "email": "jack.martinez@example.com",
            "document": "00011122233",
            "documentType": "CPF",
            "allowNotification": false,
            "address": {
                "postalCode": "01234-567",
                "street": "Rua J",
                "state": "AM",
                "city": "Manaus",
                "number": "1000"
            }
        }
    ]);
