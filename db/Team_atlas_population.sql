--
-- File generated with SQLiteStudio v3.3.3 on Thu Mar 31 11:34:55 2022
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Administrator
DROP TABLE IF EXISTS Administrator;

CREATE TABLE Administrator (
    EmailAddress VARCHAR (99),
    Pass         VARCHAR (99) NOT NULL,
    AdminID      INTEGER      UNIQUE
                              NOT NULL,
    CONSTRAINT email_pk PRIMARY KEY (
        EmailAddress
    )
);

INSERT INTO Administrator (
                              EmailAddress,
                              Pass,
                              AdminID
                          )
                          VALUES (
                              'admin@atlas.com',
                              'admin123',
                              'admin1'
                          );


-- Table: Context
DROP TABLE IF EXISTS Context;

CREATE TABLE Context (
    ContextID VARCHAR (99),
    Context   VARCHAR (99) NOT NULL,
    CONSTRAINT ContextID_pk PRIMARY KEY (
        ContextID
    )
);

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C1',
                        'Ordering food and drink'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C10',
                        'Making invitations'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C11',
                        'University life'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C12',
                        'Making travel arrangements'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C13',
                        'Exchaning personal information'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C14',
                        'Socialising'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C15',
                        'Weather'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C16',
                        'Cross-cultural experiences'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C17',
                        'Work life'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C18',
                        'Health'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C19',
                        'Housing conditions'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C2',
                        'Exchanging personal information'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C20',
                        'Weather and weather conditions'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C3',
                        'Going shopping and asking for prices'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C4',
                        'Making Appointments'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C5',
                        'Introductions'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C6',
                        'Basic employment issues'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C7',
                        'Asking and giving directions'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C8',
                        'Socialising in the country'
                    );

INSERT INTO Context (
                        ContextID,
                        Context
                    )
                    VALUES (
                        'C9',
                        'Health matters'
                    );


-- Table: Conversations
DROP TABLE IF EXISTS Conversations;

CREATE TABLE Conversations (
    ConversationID VARCHAR (99),
    languageID     VARCHAR (99)    NOT NULL,
    levelID        VARCHAR (99)    NOT NULL,
    ContextID      VARCHAR (99)    NOT NULL,
    SubContextID   VARCHAR (99)    NOT NULL,
    Grammar        VARCHAR (99),
    KeyVocab       VARCHAR         NOT NULL,
    PersonAText    VARCHAR (10000) NOT NULL,
    PersonAKey     VARCHAR         NOT NULL,
    PersonBText    VARCHAR (10000) NOT NULL,
    PersonBKey     VARCHAR         NOT NULL,
    CONSTRAINT convID_pk PRIMARY KEY (
        ConversationID
    ),
    CONSTRAINT languageID_pk FOREIGN KEY (
        languageID
    )
    REFERENCES Lang (languageID),
    CONSTRAINT levelID_pk FOREIGN KEY (
        levelID
    )
    REFERENCES Levels (levelID),
    CONSTRAINT ContextID_pk FOREIGN KEY (
        ContextID
    )
    REFERENCES Context (ContextID),
    CONSTRAINT SubContextID_pk FOREIGN KEY (
        SubContextID
    )
    REFERENCES SubContext (SubContextID) 
);

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV1',
                              'L1',
                              'A1',
                              'C2',
                              'S2',
                              'adjectives',
                              'use, snapchat',
                              '[''Hi Peter. How was your weekend?'', ''Oh really? What is she like? Did you get her Snapchat?'', "I want to see her. What''s her name? I''ll look her up on Instagram. ", "I found her! Wow, she is beautiful. I''m happy for you!"]',
                              '['''', '''', '''', '''']',
                              '[''Hi. It was good thank you. I met a nice girl.'', "She doesn''t use Snapchat. She''s very pretty. She has long brown hair and big green eyes. I like her. ", ''You can try. Her name is Natalia Black.'', ''I am happy too. And thank you. '']',
                              '['''', ''usa '', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV2',
                              'L1',
                              'A1',
                              'C3',
                              'S3',
                              'present perfect',
                              'cash, card, insert, touch, hasn''t worked, PIN',
                              '[''Hi there. May I pay for these items please?'', ''Card, please. '', ''Thank you. '', "I''m sorry about that. I will use my PIN.", ''Have a good day! Goodbye. '']',
                              '['''', '''', '''', ''PIN'', '''']',
                              '[''Hello, yes of course. Your total is £35. Will you be paying by cash or card?'', ''No problem. You can insert or touch your card to the machine. '', "I''m sorry your card hasn''t worked. Can you try again?", ''That is all done. Thank you for shopping with us. Have a good day!'']',
                              '[''en efectivo / con tarjeta'', ''insertar/ tocar'', ''no ha funcionado'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV3',
                              'L1',
                              'A1',
                              'C4',
                              'S4',
                              'negative',
                              'appointment, to book, available',
                              '[''Hello, can I make an appointment for tomorrow. '', ''2pm.'', "Sorry, those times aren''t good. Do you have 2pm the day after tomorrow?", ''Perfect, thank you.'']',
                              '[''cita'', '''', '''', '''']',
                              '[''No problem, what time would you like to book?'', "I''m sorry, that time is not available. We have 10am and 5pm.", "Yes, it''s available. I will book that for you."]',
                              '[''reservar'', ''disponible'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV4',
                              'L1',
                              'A1',
                              'C5',
                              'S5',
                              'negative',
                              'repeat',
                              '[''Hello, my name is Danielle.'', "Sorry I didn''t hear you, can you repeat that?", ''Michael?'', "It''s nice to meet you Michael."]',
                              '['''', ''repetir'', '''', '''']',
                              '[''Hello Danielle, my name is Michael.'', ''My name is Michael.'', "Yes, it''s Michael.", "It''s nice to meet you too."]',
                              '['''', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV5',
                              'L1',
                              'A1',
                              'C6',
                              'S6',
                              '',
                              'manager, to call back, to take a message, i''ve got a cold, find cover, send a message in the group chat, shift',
                              '[''Hello, is the manager there?'', "Can you tell them that I am sick and can''t come to work today.", "I''ve got a cold.", ''Not yet.'', ''I will do that now, thank you.'', ''Thank you, speak to you soon. Goodbye.'']',
                              '[''jefe,a'', '''', ''Tengo un resfriado'', '''', '''', '''']',
                              '[''They will arrive in an hour, do you want to call back or I can take a message?'', "What''s the matter?", ''Did you find cover?'', ''Send a message in the group chat, hopefully someone can cover your shift.'', ''Well, I hope you get well soon.'', ''Goodbye.'']',
                              '[''llamar de nuevo  / darle el mensaje'', '''', ''encontraste una sustitución'', ''Envía un mensaje al grupo de chat / turno'', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV6',
                              'L1',
                              'A1',
                              'C3',
                              'S7',
                              '',
                              'refund, items, unfortunately, to use, exchange, gift voucher, manager',
                              '[''Hello there. I would like a refund for these items please. '', ''That will not work. I want my money back.'', ''Fine. But I will take this up with your manager. '', ''Oh. Well, in that case I will just take the gift voucher. Thank you and have a good day. '']',
                              '[''reembolso / artículos'', '''', ''jefe,a'', '''']',
                              '[''Hi there. Unfortunately, these items look like they have been used. I can offer an exchange or a gift voucher instead.'', ''We cannot offer a refund for used items. You can exchange it for another item or I can issue you a gift voucher. '', ''I am the manager. '', ''You too. Bye! '']',
                              '[''desgraciadamente / usados / intercambio / vale regalo'', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV7',
                              'L1',
                              'A2',
                              'C7',
                              'S8',
                              'present continuous',
                              'delivery driver, having trouble, tricky, gates, statue, recommend, lift, stone, round',
                              '[''Hello there. Is this Mary?'', ''This is John, the delivery driver. I am having trouble finding your apartment. '', "I can''t see a statue. Are you sure it''s correct?", ''Oh yes, I see it. I will be there soon. Goodbye!'']',
                              '['''', ''conductor,a de reparto  / tengo un problema'', '''', '''']',
                              '["Hi, yes it is. Who''s speaking?", ''Yes it can be a little tricky. Go past the big black gates, turn left at the statue and you should see my building. I live on the 4th floor so I would recommend taking the lift.'', ''It is a big stone statue, round and grey in colour. '', ''See you soon. Goodbye!'']',
                              '['''', ''complicado / verjas / estatua / recomendaría / ascensor'', ''piedra / redonda'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV8',
                              'L1',
                              'A2',
                              'C1',
                              'S9',
                              'past perfect, past simple',
                              'wrong order, vegan, mix up, that is not good enough, waiting over, accept our sincere apologies, hurry up, starving, kitchen',
                              '[''Hi excuse me? I think I have the wrong order. '', ''I asked for a vegan pizza and this seems to have cheese and meat all over it.'', ''That is not good enough. My friends and I have been waiting over an hour already. I want a new pizza and my money back.'', ''Apology accepted. Now please hurry up, I am starving. '', ''Thank you. '']',
                              '[''pedido incorrecto'', ''vegana'', ''Eso no es suficiente / esperando sobre'', ''dese prisa / muerto,a de hambre'', '''']',
                              '[''Hi there, what seems to be the problem?'', "I''m so sorry about that there must have been a mix up. I will bring you a new one immediately. ", ''I will see if I can get that done for you. And please accept our sincere apologies.'', ''I will let the kitchen know and your pizza should be with you as soon as possible. '']',
                              '['''', ''confusión'', ''acepte nuestras más sinceras disculpas '', ''cocina'']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV9',
                              'L1',
                              'A1',
                              'C8',
                              'S10',
                              '',
                              'secured a job inteview, admin role, dress code, smart-casual, face-to-face, online, only 3 stops on the no.32 bus, let you know',
                              '[''Hi Derreck. How was your weekend?'', ''That is great news! Give me all the details.'', ''Will it be face-to-face or online?'', ''Good luck, my friend I will be thinking of you. You will do great!'']',
                              '['''', '''', ''presencial / en linea'', '''']',
                              '["Hi Pete. Well, I actually secured a job interview for this admin role. I''m so excited!", ''Well, the interview is at 10:00 tomorrow. The dress code is smart-casual so I need to wear a shirt and jeans. '', "Face-to-face so I need to be prepared. It''s not far from here, only 3 stops on the no.32 bus. ", ''Thank you! I will let you know how it goes. '']',
                              '[''conseguido una entrevista de trabajo / papel administrativo'', ''código de vestir / informal'', ''solo 3 paradas en la línea 32  de autobús'', ''haré saber'']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV10',
                              'L1',
                              'A2',
                              'C4',
                              'S11',
                              'comparative',
                              'put you down, done my teeth, trust, sooner, cancellation, appointment',
                              '[''Hi there. I would like to book an appointment with my dentist, Clara. '', ''Clara has done my teeth for the past 10 years. She is very professional and I trust her. Where is she?'', ''That is too long to wait. Do you not have anything sooner?'', ''Yes please. Thank you for that. I will see you then. Bye!'']',
                              '['''', ''cuidado mis dientes / confío'', ''antes'', '''']',
                              '["Hi there, I''m sorry but Clara is not available at the moment. Could I put you down with someone else?", ''She is on holiday until the 22nd. I can book you in with Clara on the 30th.'', ''Let me check for you. There is a cancellation on the 25th at 13:00. Would you like this appointment?'', ''No problem, Clara will see you then. Goodbye! '']',
                              '[''darle cita'', '''', ''cancelación / cita'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV11',
                              'L1',
                              'A1',
                              'C1',
                              'S12',
                              'questions',
                              'decafe latte, iced, sugar-free syrup, caramel, vanilla, hazelnut, oat milk, is that to have here or to go?',
                              '[''Could I please have a regular decafe latte.'', "That''s okay, I''ll just have a regular latte then, and could I get that iced.", ''And, do you have sugar-free syrup?'', ''Could I get the sugar-free vanilla please, and could I get that with oat milk please.'', ''To go please.'']',
                              '[''descafeinado con leche'', ''con hielo'', ''almíbar sin azúcar '', ''leche de avena'', '''']',
                              '[''We have no decafe, sorry about that.'', ''Yes.'', ''We have sugar-free caramel, vanilla and hazelnut.'', ''Is that to have in or to go?'']',
                              '['''', '''', '''', ''Es para tomar aquí o para llevar'']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV12',
                              'L1',
                              'A1',
                              'C4',
                              'S13',
                              '',
                              'we are booked',
                              '[''Hello, can I make an appointment for tomorrow.'', ''Can I book for next week Tuesday then?'', ''at 10am please.'', ''Jessica Taylor'', ''Yes, J E S S I C A, T A Y L O R.'', ''Thank you, see you then.'']',
                              '['''', '''', '''', '''', '''', '''']',
                              '["We''re booked for the next week unfortunately.", ''Of course, what time?'', "What''s your name?", ''Can you spell that for me?'', "That''s all done for you, see you next week."]',
                              '[''hemos reservado'', '''', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV13',
                              'L1',
                              'A1',
                              'C6',
                              'S14',
                              'present simple',
                              'interview, right, turn left',
                              '[''Good afternoon, how can I help you?'', ''What time is the interview?'', ''With who?'', "Johnathan works in the other building, it''s not far.", ''If you go right when you leave the building and then turn left. Best of luck with the interview.'']',
                              '['''', '''', '''', '''', ''a la derecha / doble a la izquierda'']',
                              '[''Good afternoon, I have an interview here today.'', ''at 13:30.'', "it''s with Johnathan.", ''How do I get there?'', ''Thank you very much.'']',
                              '[''entrevista'', '''', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV14',
                              'L1',
                              'A1',
                              'C1',
                              'S15',
                              '',
                              '',
                              '[''Good evening, how is it going?'', ''Can I get you some drinks while you look at the menu?'', "I''ll get that for you now. Is this your daughter? She''s beautiful.", "Of course, excuse me, I''ll get your drinks."]',
                              '['''', '''', '''', '''']',
                              '[''Excellent thanks.'', ''Yes, can we get tap water for the table and two lemonades.'', "Actually, she''s my wife."]',
                              '['''', ''agua del grifo'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV15',
                              'L1',
                              'A2',
                              'C1',
                              'S16',
                              'past simple, ',
                              'reservation, delay, intended, on the house',
                              '[''Hi there. Do you have a table for 4?'', ''Yes, I do, for 8 pm'', "It''s Jones.", "I''m sorry, but I booked the table for 8pm - and it is now 8pm. ", ''Well, I suggest that you ask them to hurry up. We are going to sit down. '', "Ha! That''s a typical trick! You delay the table and ask me to wait in the bar so that I have to buy some drinks!", ''That sounds more like it. '']',
                              '['''', '''', '''', '''', '''', ''retrasa '', ''gratuita'']',
                              '[''Good evening. Do you have a reservation with us?'', ''What is your name?'', "Ok, I can see your booking. I am sorry, the table isn''t ready yet. It will be about 30 minutes. ", ''I do understand, but the people who booked the table at 6pm have not finished their meal. '', ''May I ask you to wait in the bar while I get your table ready. '', ''That is not what I intended. I am sorry that your table is not ready. Please can you wait in the bar. May I get you a drink on the house?'']',
                              '[''reservación'', '''', '''', '''', '''', ''pretendía'']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV16',
                              'L1',
                              'A2',
                              'C3',
                              'S3',
                              'present perfect',
                              'cash, card, insert, touch, hasn''t worked, ',
                              '[''Hi there. May I pay for these items please?'', ''Card, please. '', ''Thank you. '', ''Let me try another card. Here it is!'', ''How embarassing. I will go and get some cash from the bank. '', ''I will be back as soon as possible. '']',
                              '['''', '''', '''', '''', '''', '''']',
                              '[''Hello, yes of course. Your total is £35. Will you be paying by cash or card?'', ''No problem. You can insert or touch your card to the machine. '', "I''m sorry your card hasn''t worked. Can you try again?", "I''m sorry, but this card hasn''t worked either. ", ''Ok. No problem. I can hold onto your shopping for 30 minutes. '']',
                              '[''en efectivo o con tarjeta'', ''insertar/ toque'', ''no ha funcionado'', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV17',
                              'L1',
                              'B1',
                              'C3',
                              'S3',
                              'passive voice',
                              'cash, card',
                              '[''Hi there. May I pay for these items please?'', ''£255! Are you sure? '', ''Oh. That is too much. I will only buy one of the pairs of trousers. '', "The blue. I''m so sorry about this. ", "Ok. Here''s my card. ", "Oh dear. I think I''ll leave it. Bye. "]',
                              '['''', '''', '''', '''', '''', '''']',
                              '[''Hello, yes of course. Your total is £255. Will you be paying by cash or card?'', "Yes. You have bought 2 pairs of trousers at £65 each, and a jumper - that''s £125. That''s £255 in total. ", ''Which one - the blue or the black. '', "Not a problem. Right, so, that''s one pair of trousers at £65 and a jumper at £125. So, £190 please.", "Right, please can you insert your card. Oh, I''m sorry, the payment has not been authorised. "]',
                              '[''en efectivo o con tarjeta'', '''', '''', '''', ''autorizado'']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV18',
                              'L1',
                              'A1',
                              'C1',
                              'S16',
                              '',
                              'reservation, wait, about',
                              '[''Hi there. Do you have a table for 4?'', "I''m sorry I don''t. ", ''How long is the wait for a table? '', ''Yes, no problem at all. We know this restaurant is popular. '', ''Smith.'']',
                              '['''', '''', ''espera'', '''', '''']',
                              '[''Good evening. Do you have a reservation with us?'', "I''m afraid we''re very busy tonight so there are no free tables. Would you like to wait or come back later?", "It is about one hour. I''m sorry about that. Are you happy to wait at the bar? ", ''I need to book you in. What is your name?'', "Great. You are booked in for 9 o''clock. The bar is over there. I will call you when your table is ready. "]',
                              '[''reservación'', '''', ''sobre '', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV19',
                              'L1',
                              'A1',
                              'C7',
                              'S8',
                              '',
                              'Delivery driver, having trouble',
                              '[''Hello there. Is this John?'', ''This is Anna, the delivery driver. I am having trouble finding your house. '', "I''m parked outside the train station. The train station is on my left. ", ''Oh yes, I see it. I will be there soon. Goodbye!'']',
                              '['''', ''conductor,a del reparto / teniendo un problema'', '''', '''']',
                              '["Hi, yes it is. Who''s speaking?", ''Where are you right now?'', "Oh, you''re close by. Just cross the street, my house is number 12. It has a red door. ", ''See you soon. Goodbye!'']',
                              '['''', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV20',
                              'L1',
                              'A2',
                              'C9',
                              'S17',
                              '',
                              '',
                              '[''Hey, what are your plans for Saturday night?'', "Oh no, I didn''t know that. When will you return?", ''I hope she gets well soon.'', ''Let me know if you want to talk about it, okay. '', ''Take care.'']',
                              '['''', '''', '''', '''', '''']',
                              '["I''m in Italy, didn''t you know?", ''I meant to stay for 2 weeks but my grandma is unwell, so I am staying another week.'', ''Thank you, it seems as if she will.'', ''I will, thank you for offering. Take care, speak soon.'']',
                              '['''', ''no se encuentra bien'', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV21',
                              'L1',
                              'A2',
                              'C10',
                              'S18',
                              'present + infinitive',
                              'charitable organisation, don''t give to charity, choose, sign up, leave me alone',
                              '[''Good morning sir, can I speak with you for a moment?'', ''It will just take a second.'', ''I just wanted to speak to you about our charitable organisation.'', "So you don''t give to charity?", ''But sir, if you give me your email then you can choose to sign up or not in your own time.'']',
                              '['''', '''', ''organización benéfica'', ''no dona a organizaciones benéficas'', ''elegir / inscribirse'']',
                              '[''No, I am busy.'', ''I am going to work.'', ''I am not interested.'', ''Stop following me.'', ''Leave me alone.'']',
                              '['''', '''', '''', '''', ''Déjeme en paz'']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV22',
                              'L1',
                              'A2',
                              'C10',
                              'S19',
                              '',
                              'to go for lunch, I''m afraid not, days do you have off, free, that''s a shame',
                              '[''Do you want to go for lunch at the weekend?'', ''Which days do you have off next week?'', ''I go to University on those days unfortunately.'', ''I am also free on Monday morning. How about we meet at 10 at the cafe near your house.'', ''See you then!'']',
                              '[''salir a comer fuera'', ''días estás libre'', '''', '''', '''']',
                              '["I''m afraid not, I work on weekends.", ''I am free on Tuesday and Wednesday'', "That''s a shame, what about on Monday morning?", ''Perfect, see you on Monday.'']',
                              '[''Me temo que no'', ''libre'', ''Es una pena'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV23',
                              'L1',
                              'B2',
                              'C3',
                              'S20',
                              '',
                              'launch, models, slot',
                              '[''Hi, can I buy this phone?'', "No, I didn''t.", "No, that''s way too long to wait to buy a phone.", ''Fine, I will make the reservation. But is there anything you can offer me in return for my having to wait?'']',
                              '['''', '''', '''', '''']',
                              '[''Did you make a reservation?'', ''You need a reservation, I can make one for you but it will be in about 30 minutes. Is that okay?'', ''Well, unfortunately, we are extremely busy because of the launch of our newest phone, and two models have sold out already today. So if you can wait a little while we can get you a slot. Is that okay?'', "I''m afraid not, we have to do reservations today because we are so busy. Next time you should book online to avoid the wait."]',
                              '['''', '''', ''lanzamiento / modelos / espacio libre'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV24',
                              'L1',
                              'A2',
                              'C1',
                              'S21',
                              '',
                              'mix up',
                              '["Excuse me, where is my coffee. I''ve been waiting over 20 minutes.", ''This is unacceptable, I am very busy this morning. Some people who ordered after me have already got their drinks.'', ''Thank you, I ordered a mocha.'', ''Thank you very much.'']',
                              '['''', '''', '''', '''']',
                              '["We''re really busy, they are making the drinks as fast as they can, can you wait a little longer?", "I''m sorry, I will check how long it will be. What did you order?", ''Sorry there was a mix up, I will make it for you right away.'']',
                              '['''', '''', ''confusión'']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV25',
                              'L1',
                              'A1',
                              'C2',
                              'S22',
                              '',
                              'head off, give out, I suppose, username',
                              '["It''s getting late, I think I''m gonna head off.", ''I know. But I have to work. '', ''Well, bye.'', "Sorry, I don''t give out my number.", ''Sure, I suppose.'']',
                              '[''marchar'', '''', '''', ''doy'', ''supongo que sí'']',
                              '["That''s a shame, it was nice getting to know you.", ''I understand. I work too.'', ''Oh, can I get your number?'', ''What about your instagram?'', "What''s your username?"]',
                              '['''', '''', '''', '''', ''nombre de usuario'']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV26',
                              'L1',
                              'A2',
                              'C8',
                              'S23',
                              '',
                              'half-sister, only child, noisy',
                              '[''Who were you chatting to in the cafe?'', ''How do you know each other?'', "Really? But you don''t look alike.", "No, I''m an only child.", ''I think you are lucky. How nice to have a big family.'', ''No, my mum hates animals.'', ''Yes, it was very quiet. But I had many good friends. '']',
                              '['''', '''', '''', ''hijo,a único,a'', '''', '''', '''']',
                              '["Oh, that''s Suzanna.", "She''s my sister.", "Yes, she''s my half sister actually. Do you have any siblings?", ''You are lucky!  I have five sisters - it is very noisy at home.'', ''Yes, we are. And we also have 3 dogs and 2 cats. How about you?'', ''Must have been very quiet at home then!'']',
                              '['''', '''', ''media hermana'', ''ruidoso'', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV27',
                              'L1',
                              'A2',
                              'C1',
                              'S24',
                              '',
                              'almond, oat, soya, peppermint, subscription, scan',
                              '[''Good morning, can I get a large almond milk latte please?'', "In that case I''ll just have a peppermint tea.", ''No, thank you.'', ''I have a subscription with you.'', ''No problem. '', ''You too!'']',
                              '[''almendra'', '''', '''', ''suscripción'', '''', '''']',
                              '[''Sorry about this but, we are all out of almond milk. We do have oat milk or soya milk though. '', ''Sorry about that, can I get you anything else?'', "That''ll be 2.40 please.", ''Can you scan the QR code for me?'', ''Thank you. Have a nice day.'']',
                              '[''avena / soja'', ''menta'', '''', ''escanear'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV28',
                              'L1',
                              'A2',
                              'C4',
                              'S25',
                              'I would like',
                              'earache, flujab',
                              '["Good Morning, I''d like to make an appointment with Dr Tiberal.", ''27th of June 1989'', "It''s Jane Brown.", ''I have had an earache for the last two days and I would like to see the doctor.'', ''Can I have 14:45 please.'', ''Actually, I would prefer to do it another time.'', ''I will, goodbye.'']',
                              '['''', '''', '''', ''dolor de oído'', '''', '''', '''']',
                              '["What''s your date of birth?", ''And your name?'', "Thank you. So, Ms Brown, what''s the problem?", ''Okay, we have nothing today. However, we have appointments tomorrow at 10:00 or 14:45.'', ''Of course, and I can also see from your record that you need a flu jab. Can I book you in for that too?'', "That''s fine, but please book for your flu jab soon.", ''Goodbye.'']',
                              '['''', '''', '''', '''', ''vacuna de la gripe'', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV29',
                              'L1',
                              'B1',
                              'C11',
                              'S26',
                              '',
                              'assignments, due, distracted, structure, maintain',
                              '[''How are you?'', "I''m stressed.", "I have two assignments and they are both due next Monday. It''s just too much!", "It''s hard for me to study with other people, because I get distracted.", "That would be really helpful. But I know that I can''t sit in the library for hours. ", ''That would be really helpful, thank you.'']',
                              '['''', '''', ''trabajos / hay que entregarlos'', ''me distraigo'', '''', '''']',
                              '["I''m doing okay, you?", ''Why are you stressed?'', "Well, I have the same assignments, why don''t we meet in the library and study together?", "Well, I don''t get distracted. Look, we can talk about the structure and share some ideas. ", "You''re not meant to. We will take a short break every couple of hours - that''s the way to maintain focus!"]',
                              '['''', '''', '''', ''estructura'', ''mantener'']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV30',
                              'L1',
                              'A2',
                              'C12',
                              'S27',
                              '',
                              'valid, misunderstood, outstanding',
                              '[''Good morning, tickets please. '', "Your ticket isn''t valid for this part of the journey. You can pay the rest by card now. ", "I''m sorry you must have misunderstood. Your ticket expired 3 stops ago so you have to pay up or I''m going to have to ask you to get off at the next station.", ''£3.20 please. '', ''Thank you. Have a good day. '']',
                              '['''', ''válido'', ''malentendido'', '''', '''']',
                              '[''Good morning, here you go. '', ''But the lady at the ticket office told me it will be okay for the whole journey. '', ''Fine. How much is the outstanding amount?'', "Here''s my card.", ''You too. '']',
                              '['''', '''', ''pendiente'', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV31',
                              'L1',
                              'B1',
                              'C12',
                              'S28',
                              '',
                              'QR code, rail card',
                              '[''Good morning, tickets please. '', ''Would you like to buy one now? '', "if you can''t find the paper copy, the ticket is also available on your phone sir. ", ''Just show me the QR code. Thank you. Now, I see you have a rail card. Please may I see it? '', ''Thank you that is all done. Have a nice day!'']',
                              '['''', '''', '''', ''código QR / tarjeta de tren'', '''']',
                              '[''Good morning. Oh no..I think I forgot my ticket. Can you wait a moment?'', "No, I''m sure I have it somewhere just give me a minute. I printed off a copy yesterday evening. ", "You''re right, it''s right here. What do I do now?  ", ''Here it is. I know that this is stored on my phone. '', ''Have a good day!'']',
                              '['''', '''', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV32',
                              'L1',
                              'A2',
                              'C13',
                              'S29',
                              '',
                              'age restricted',
                              '[''Hi there, I have a package for Ms. Anna Smith?'', ''Ms. Smith can I see some ID please as the item you have ordered is age restricted. '', ''I believe the package contains a set of kitchen knives. '', ''Thank you. '', ''Can you confirm your birthday for me?'', "Thank you, here''s your item. Have a good day!"]',
                              '['''', ''edad restringida'', '''', '''', '''', '''']',
                              '["Hi, that''s me, thanks. ", "Oh? I don''t remember ordering anything dangerous. ", ''Oh yes of course! Sorry, I will get my ID right away. '', ''Here you go. '', ''17th of May 1989. '', ''Thank you, have a good day. '']',
                              '['''', '''', '''', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV33',
                              'L1',
                              'A1',
                              'C13',
                              'S30',
                              '',
                              'parcel, neighbour, corridor, signing',
                              '[''Hello there, how can I help?'', ''Sure, no problem. Which neighbour?'', ''All done.'', "Sarah Smith. And that''s S-A-R-A-H with a H at the end. ", ''You too, bye. '']',
                              '['''', '''', '''', '''', '''']',
                              '["Hi I have a parcel for your neighbour, but they''re not home, can I leave it with you?", ''Number 17, down the corridor, on the left. Would you mind signing here?'', ''And just to confirm, what is your name?'', ''Thanks Sarah. Have a good day!'']',
                              '[''paquete / vecino'', ''pasillo / firmar'', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV34',
                              'L1',
                              'A2',
                              'C5',
                              'S31',
                              '',
                              'exhausting but rewarding',
                              '["Hi, how''s it going?", "I''m great. Is it your first day today?", "Don''t be nervous we were all new once. I''m Claire by the way, it''s nice to meet you. ", ''Oh a long time. Over 5 years. How are you finding the job so far?'', "You will get used to it don''t worry. "]',
                              '['''', '''', '''', '''', '''']',
                              '[''Good thanks, how are you?'', ''Yes it is. I am quite nervous. '', "Nice to meet you too. I''m Lucy. How long have you worked for the company?", ''Exhausting but rewarding. '']',
                              '['''', '''', '''', ''Agotador pero gratificante'']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV35',
                              'L1',
                              'A2',
                              'C5',
                              'S32',
                              'present continuous',
                              'following, position, paperwork',
                              '[''Good morning, am I speaking to Lucy?'', "Hi Lucy. I''m calling from H&M, following your interview we are delighted to offer you a position. When can you start?", "That''s perfect. When you come in to the shop, just ask for me, my name is Tim Brown. Can you please bring your passport so we can get the necessary paperwork done.", ''How about 10am?'', ''Great I will see you Monday at 10 am. Bye now!'']',
                              '['''', ''después / posición'', ''papeleo'', '''', '''']',
                              '["Hi, yes that''s me. ", "That''s brilliant news! I am busy this weekend but I can start as soon as Monday.", ''Yes I will do. Thank you so much again. What time should we meet?'', "That''s perfect. See you then!", ''Bye-bye!'']',
                              '['''', '''', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV36',
                              'L1',
                              'A2',
                              'C7',
                              'S33',
                              '',
                              'patient, admitted, ward',
                              '["Hi there I''m here too see Mr. Smith. ", ''David Smith, he was admitted yesterday around 9pm.'', "I''m his wife.", ''Here you go. '', ''Thank you very much for your help. Have a good day!'']',
                              '['''', ''ingresado'', '''', '''', '''']',
                              '[''Good morning, I need the full name of the patient and the time he was taken in.'', ''We are only accepting close relatives of Mr. Smith for visits at the moment. What is your relation to the patient? '', ''Great Mrs. Smith I just need to see some ID.'', ''Thank you. His ward is the second door on the left at the end of the corridor. '', ''Thanks, you too. '']',
                              '[''paciente '', '''', '''', ''sala'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV37',
                              'L1',
                              'B1',
                              'C3',
                              'S34',
                              ' ',
                              'notice, cancellation charge, walk-ins, last minute',
                              '[''Good morning, how can I help?'', ''When is your appointment?'', "We require 24 hours notice to cancel appointments, otherwise there''s a cancellation charge of £20.", "Because our salon is very popular and we are often booked in advance and we don''t do walk-ins. Next time, please book at time that you can make.", "Unfortunately, that''s the agreement you made when making the appointment."]',
                              '['''', '''', ''aviso / coste de cancelación'', ''tratamientos sin cita previa'', '''']',
                              '["Good morning, I''d like to cancel my appointment please.", ''Today at 4pm.'', ''Why do I have to pay to cancel my appointment?'', "I have to work last minute and can''t make it at 4pm anymore, I can''t afford to pay for a haircut that I didn''t get.", ''Well, I will not be coming back here again.'']',
                              '['''', '''', '''', ''hasta el último minuto'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV38',
                              'L1',
                              'A2',
                              'C1',
                              'S35',
                              '',
                              'a tab, 2 for 1 offer, valid',
                              '[''Hi there we would like to order 2 cocktails please.'', ''Pay now please.'', ''I thought cocktails were on a 2 for 1 offer?'', ''Well it didn’t say that anywhere. We will leave it for now, thank you.'', ''Thanks, you too.'']',
                              '['''', '''', ''oferta de dos por uno'', '''', '''']',
                              '[''Coming right up. Would you like to start a tab for your table or pay now?'', ''Okay your total is £22.50 please.'', ''That deal is only valid from Monday to Thursday I’m afraid.'', ''I’m sorry to hear that. I hope you have a good night.'']',
                              '[''una cuenta'', '''', ''válido'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV39',
                              'L1',
                              'A1',
                              'C1',
                              'S36',
                              '',
                              'free refills, soft drinks',
                              '[''Hi there we would like to order 2 cocktails please.'', ''Start a tab please.'', ''Our table is number 17 and here are my details.'', ''Great thanks!'']',
                              '['''', '''', '''', '''']',
                              '[''Good evening. Would you like to start a tab for your table or pay now?'', ''Great I will just need your card details and table number please.'', ''Thank you. Just to let you know we have a 2 for 1 offer on cocktails all night and free refills on soft drinks.'', ''Thank you that is all done. Enjoy your night!'']',
                              '['''', '''', ''recargas gratuitas / bebidas sin alcohol'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV40',
                              'L1',
                              'A1',
                              'C10',
                              'S37',
                              '',
                              'lucky',
                              '[''Hi John did you get my letter?'', ''Yeah that one. '', ''A trip to Disneyland? Your kids are lucky. Have fun and take lots of pictures! '', "That''s okay. Have a good one!"]',
                              '['''', '''', ''suerte'', '''']',
                              '["About your son''s birthday party next week? ", "Ah, unfortunately we won''t be able to come. My wife planned a trip to Disneyland for the whole family and so we''re going to be away all week.", ''Thanks I will. And sorry again for not being able to come. '', ''You too. '']',
                              '['''', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV41',
                              'L1',
                              'A1',
                              'C10',
                              'S38',
                              '',
                              'setting up',
                              '[''Hi Mary did you get my letter?'', ''Yes that one. '', ''The party starts at 14:00.'', "I actually do. It''s not easy organising a party for 30 kids. ", ''That would be great.  See you then. '']',
                              '['''', '''', '''', '''', '''']',
                              '["Hi! About your son''s birthday next week?", ''Of course! Me and the kids would be delighted. What time does it start?'', ''Do you need help setting up?'', ''I will come over at 12:00 then. '', ''See you then! '']',
                              '['''', '''', ''para colocar las cosas'', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV42',
                              'L1',
                              'A1',
                              'C13',
                              'S39',
                              '',
                              'close to the beach, ancient, festivals',
                              '[''Hi, my name is Claire.'', ''Nice to meet you too, where are you from?'', "I''m from Cardigan.", "It''s a small town in the north of Wales.", "It is a town close to the beach. It''s also got a lovely river. You should visit sometime.", "Hm, there''s an ancient castle, they have festivals there in the summertime. There is also a market, a museum and a theatre."]',
                              '['''', '''', '''', '''', ''cerca de la playa'', ''antiguo / festivales'']',
                              '["Nice to meet you, I''m Robert.", "I''m from London, how about you?", "Oh, where is that? I''ve never heard of it.", ''What is it like?'', "I don''t like going to the beach because I don''t like sand. Is there anything else there to see?", ''That does sound like a nice place, maybe I will visit sometime.'']',
                              '['''', '''', '''', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV43',
                              'L1',
                              'B1',
                              'C3',
                              'S40',
                              'past perfect, subsitution',
                              'in stock, similar, recommend, memory, processor, discount',
                              '[''Hi, can I buy this laptop?'', ''Thank you.'', ''I was hoping for a more neutral colour.'', ''No thank you, I have already travelled 40 minutes to come here. Are there any other similar laptops you can recommend to me?'', "It''s £50 outside of my price range.", "That''s perfect, can I buy this one?", ''Thank you very much.'']',
                              '['''', '''', '''', ''similares / recomendar'', '''', '''', '''']',
                              '["That one is quite popular, let me check if it''s in stock.", "I''ve had a look and we don''t have the black or grey in stock, however we do have the pink avaliable.", ''Unfortunately this one is very popular, the black is avaliable in another store half an hour away. Would you like me to reserve it for you? '', "There is one here in grey, that has more memory and a better processor but it''s more expensive.", ''Are you a student? Because we have a student discount and that will make it £40 cheaper.'', "Of course, I''ll put it behind the till for you."]',
                              '[''en stock'', '''', '''', ''memoria / procesador '', ''descuento'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV44',
                              'L1',
                              'A1',
                              'C11',
                              'S41',
                              '',
                              'assignments, next door',
                              '[''Hey, good to see you.'', "Not good, I''m stressed.", "I have two assignments on Monday. I can''t do them both.", "I don''t know. I don''t like the library, it''s too quiet.", ''Actually that would be nice, should we go today after class?'', ''Okay, see you then!'']',
                              '['''', '''', ''trabajos '', '''', '''', ''de al lado'']',
                              '["Hey, how''s things?", "What''s happening?", "Well, I have the same assignments, let''s study together in the library?", "Let''s study in a cafe then, we can drink coffee and study. ", "I''m free after class, let''s meet at the cafe next door.", ''See you later!'']',
                              '['''', '''', '''', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV45',
                              'L1',
                              'B1',
                              'C14',
                              'S42',
                              '',
                              'blowdry',
                              '[''Hiya, long time no see!'', "I''ve been good, yourself? You look great by the way, did you change your hair?", ''Where is it?'', ''Let me write that down, I might just check it out. How much was it?'', "£200! That''s too expensive.", "Thank you for saying that, but I dye my hair at home on my own. It''s about £10 at the drugstore.", ''You as well, bye.'']',
                              '['''', '''', '''', '''', '''', '''', '''']',
                              '["Hi, yeah, it''s been ages. How are you getting on?", ''Thanks for noticing, I found this excellent new hairdresser.'', "It''s not far from my house? Maybe 20 minutes by bus. It''s called Serenity Salon.", ''I had a cut and blowdry and a full head of colour so it was £200.'', "Well it is worth to have good colour. Your hair is lovely natural anyway, you don''t need an expensive colour.", "I couldn''t even tell, it looks amazing. Anyway I''ve got to run. It was lovely seeing you."]',
                              '['''', '''', '''', ''secado'', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV46',
                              'L1',
                              'B1',
                              'C15',
                              'S43',
                              '',
                              'flooded, replacement bus, soaked',
                              '["Hey why weren''t you at class this morning?", "Tell me about it. It was meant to be sunny, so I didn''t bring an umbrella and got completely soaked. ", ''Anyway, do you want the notes from the class this morning?'', ''I will take a picture and send it to you later. I have to run now but it was nice talking you!'', ''Bye. And good luck for your journey home. '']',
                              '['''', ''empapado'', '''', '''', '''']',
                              '[''Hi! Well because of the rain my station was completely flooded. I had to get a replacement bus which was 30 minutes late. '', ''This is why I always carry an umbrella. You never know. '', ''Yes please, that would be great. '', ''Same here. See you later!'', ''Thanks, bye!'']',
                              '[''inundada / autobús de reemplazo'', '''', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV47',
                              'L1',
                              'A1',
                              'C16',
                              'S44',
                              '',
                              'spices, boil, text',
                              '[''What is this?'', ''What kind of tea?'', ''Yes, I like it. I want to make it at home. '', ''How do I make it?'', "Can you text it to me so I don''t forget.", ''Thank you.'']',
                              '['''', '''', '''', '''', ''enviarme un mensaje'', '''']',
                              '["It''s tea.", "Chai tea. It''s made with black tea, milk and spices. Do you like it?", ''You can buy the spices at the supermarket.'', ''First you boil the milk, then you add the teabag and spices.'', "No problem, I''ll do it now."]',
                              '['''', ''especias'', '''', ''hierves'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV48',
                              'L1',
                              'A2',
                              'C14',
                              'S45',
                              'much',
                              'succulent, tropical, sunlight, link',
                              '[''Is this plant real?'', ''What kind of plant is it?'', ''What is that?'', ''Do you have any other plants?'', ''I have many hobbies. I like painting the most.'', ''Yes, I have them on tiktok. Do you want to see?'']',
                              '['''', '''', '''', '''', '''', '''']',
                              '["Yes, it''s real.", "It''s a succulent.", "It''s a tropical plant that doesn''t need much water but needs a lot of sunlight.", "Yes I have a lot of other plants, it''s my hobby. Do you have a hobby?", ''Do you have any pictures? I want to see them.'', ''Can I follow you? Send me the link.'']',
                              '['''', ''suculenta'', ''tropical / luz del sol'', '''', '''', ''enlace'']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV49',
                              'L1',
                              'A2',
                              'C10',
                              'S46',
                              'gerund',
                              'wedding, RSVP',
                              '[''Hey Bill, did you get my wedding invitation?'', "I didn''t recieve your RSVP yet.", ''So sorry to hear that, hopefully we can all get together another time.'', "That''s okay. Have a good one!"]',
                              '[''boda'', ''confirmación'', '''', '''']',
                              '[''I did, yes.'', "Unfortunately, we won''t be able to come, the invitation said that it''s adults only but there won''t be anyone to look after our daughter.", ''Congratulations and thank you for inviting us anyway.'', ''You too. '']',
                              '['''', ''confirmación'', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV50',
                              'L1',
                              'A2',
                              'C10',
                              'S47',
                              '',
                              'catering, schedule, vegetarian',
                              '[''Hi Rachel, did you get my wedding invitation?'', "I didn''t recieve your RSVP yet.", "I''m booking the catering next week, so can you get back to me as soon as possible?", ''March 18th.'', ''While I have you, which meal would you like?'', ''Thanks so much, see you soon!'']',
                              '['''', '''', ''catering '', ''calendario'', '''', '''']',
                              '[''I did, yes.'', "I don''t know if I can make it yet, I have to travel a lot for work.", ''Let me check my schedule, what was the date again?'', ''That fits perfectly actually/ It may well be possible/ I have to check'', "I''ll have the vegetarian options please, if you don''t mind.", ''Look forward to it!'']',
                              '['''', '''', '''', '''', ''vegetarianas'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV51',
                              'L1',
                              'A2',
                              'C16',
                              'S48',
                              '',
                              'omelette, takeaway box, recycleable',
                              '[''What is this?'', ''It looks like an omelette.'', ''Yes I do. How do you make it?'', ''Oh, that would be lovely. Remind me to return your container next time I come over.'', ''Excellent, is it recycleable?'']',
                              '['''', ''tortilla'', '''', '''', ''reciclable'']',
                              '["It''s a Tortilla.", "Yes, it''s an egg and potato omelette. Do you like it?", "I didn''t make it, my mum made it  for me. Would you like to take some home? I can put a piece in a container.", "Don''t worry, it''s just an old takeaway box. It''s clean.", ''I think so, but you must check. '']',
                              '['''', '''', '''', ''caja para llevar'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV52',
                              'L1',
                              'B2',
                              'C17',
                              'S49',
                              '',
                              'no kidding, workload, manageable, decent',
                              '["Hi I haven''t seen you around, are you new?", ''No kidding! How are you finding it so far?'', "Yeah, it''s decent for the money. I''m Clare by the way, nice to meet you. ", ''So hey, some of us are going for drinks on Friday, would you like to join us? '', "8pm at the bar down the road. They have 2 for 1 cocktails all night so we''re going to have fun! ", ''Awesome, see you there Lucy! '']',
                              '['''', ''En serio'', ''decente'', '''', '''', '''']',
                              '[''Hi, yeah I am! Yesterday was my first day.'', ''Pretty good. Everyone is really nice and the workload is managable. '', "Nice to meet you too. I''m Lucy. ", ''Sure, what time?'', ''Oh great! I will see you guys there. '']',
                              '['''', ''carga laboral / llevadera'', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV53',
                              'L1',
                              'A2',
                              'C1',
                              'S35',
                              '',
                              'happy hour',
                              '[''Hi there we would like to order 2 cocktails please.'', ''I will have an espresso martini and my friend will have the pina colada.'', ''Card, please. '', ''We only ordered two, why are there 4 drinks?'', ''Wow, great thanks! '']',
                              '['''', '''', '''', '''', '''']',
                              '["Good evening. Here''s the menu which one would you like?", ''Great, coming right up. Are you going to be paying card or cash?'', ''There, these are ready for you. '', ''Oh, it is happy hour, which means all are cocktails are on a 2 for 1 offer. '', "You''re welcome. Enjoy your night. "]',
                              '['''', '''', '''', ''"happy hour" (the English expression is used)'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV54',
                              'L1',
                              'B1',
                              'C1',
                              'S50',
                              'present continuous, past perfect, adverbs',
                              'scan the barcode, system ensures, assure, policy',
                              '[''Hi there, can we order some cocktails please?'', "We have already waited half an hour for a table. Can''t I just pay you and have my drinks?", "I understand that but it will be another hour until we get our drinks and I''m not willing to wait that long. ", ''We will see about that. '']',
                              '['''', '''', '''', '''']',
                              '["Good evening, I''m sorry but we''re only taking orders through our app at the moment. If you take a seat at your table you can scan the barcode and your drinks will be delivered right to your table. ", "Unfortunately, not. It is a Friday night, we''re extremely busy and this system ensures everyone gets their orders on time. ", "You''re welcome to go somewhere else, but I can assure you all bars operate under the same policy at the moment. "]',
                              '[''escanee el código de barrras '', ''sistema asegura que'', ''asegurarle / política '']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV55',
                              'L1',
                              'B2',
                              'C12',
                              'S37',
                              'future tense',
                              'airbnb, accomodation, tricky, resort',
                              '[''Hi John did you get my letter?'', ''Yeah that one. '', ''A trip to Disneyland? In the middle of summer? You must have got a good deal. '', "Ah, I''ve heard the parking can be tricky if you''re not staying inside the resort though.", "Wow, you really thought about everything! Well, have a good time and I will see you when you''re back."]',
                              '['''', '''', '''', ''complicado / resorte'', '''']',
                              '["About your son''s birthday party next week? ", "Ah, unfortunately we won''t be able to come. My wife planned a trip to Disneyland for the whole family, so we''re going to be away all week.", "We did!  Kids under the age of 8 get free entry and we''re staying in an Airbnb so we''re saving a lot on food and accomodation too. ", ''No need for parking, the Airbnb is actually only a 15 minute walk from the park!'', ''Thanks, we will. See you later! '']',
                              '['''', '''', ''Airnbnb / alojamiento'', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV56',
                              'L1',
                              'B1',
                              'C10',
                              'S51',
                              'modals',
                              'pink, unicorn, theme',
                              '[''Hi Mary did you get my letter?'', ''Yes that one. '', ''The party starts at 14:00.'', "I actually do. It''s not easy organising a party for 20 kids. ", ''My daughter wanted a pink, unicorn theme so if you have any pink decorations that would be great. '', ''Yeah, that will give us enough time. Thank you so much for this. '']',
                              '['''', '''', '''', '''', ''rosa / decoraciones de unicornio'', '''']',
                              '["Hi! About your daughter''s birthday party next week?", ''Of course! Me and the kids would be delighted to attend. What time does it start?'', ''Do you need help setting up?'', "Yeah I know, it''s hard work. Do you need me to bring anything? Food, decorations?", ''I will see what I can do. Shall I meet you at your place at 12?'', "Oh, don''t mention it! See you soon. "]',
                              '['''', '''', '''', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV57',
                              'L1',
                              'A2',
                              'C18',
                              'S52',
                              '',
                              'making his rounds',
                              '["Hi there I''m here to see Mr. Smith. ", ''David Smith, he was admitted yesterday around 9pm.'', "I''m his wife.", ''Here you go. '', ''How is he doing? Is he eating normally? '', '''']',
                              '['''', '''', '''', '''', '''', '''']',
                              '[''Good morning, I need the full name of the patient and the time he was taken in.'', ''We are only accepting close relatives of Mr. Smith for visits at the moment. What is your relationship to the patient? '', ''Great Mrs. Smith I just need to see some ID.'', ''Thank you. His room is the second door on the left at the end of the corridor. '', ''Yes, he had his breakfast this morning everything seems good. The doctor is just making his rounds so you will be able to talk to him about this in more detail. '']',
                              '['''', '''', '''', '''', ''haciendo la ronda'']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV58',
                              'L1',
                              'B1',
                              'C17',
                              'S32',
                              'conditional',
                              'notice, reception, dress code, uniform, insurance card, attire',
                              '[''Good morning, am I speaking to Lucy?'', "Hi Lucy. I''m calling from H&M head office, following your interview we are delighted to offer you a position. Would you be able to start on Monday?", "That''s perfect. When you come in ask for me at reception, my name is Tim Brown. Can you please bring your passport so we can get the necessary paperwork done.", ''How about 10 am?'', "If you have an insurance card/ national insurance number bring that along too. There''s no uniform but dress smartly. Blazer, black trousers, basic office attire. ", ''My pleasure Lucy, welcome to the team. Bye! '', ''Hello? who is it?'']',
                              '['''', '''', ''recepción'', '''', ''tarjeta de seguro / número de la Seguridad Social/ indumentaria'', '''', '''']',
                              '["Hi, yes that''s me. ", "That''s brilliant news! I had to give 2 weeks notice at work, so I can start on Monday in 2 weeks.", ''Yes I will do. Thank you so much again. What time should we meet?'', "That''s perfect. Is there anything else I should bring? And is there a dress code or uniform? ", ''Okay, thank you so much. See you soon!'']',
                              '['''', ''aviso'', '''', ''código de vestir / uniforme'', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV59',
                              'L1',
                              'B1',
                              'C19',
                              'S53',
                              'passive voice, emphatic, ',
                              '',
                              '[''Oh right, is everything okay?'', "I don''t have any packages for anyone at the moment, no.", "Those are my feet, but I don''t have that package, when was it?", ''I do remember that package, but number 8 came and collected it.'', "Since I work from home, I collect the packages for the whole apartment block. I get at least two for her a week. I''m not sure why she didn''t deliver it to you when she saw it wasn''t hers. I''m really sorry about that.", "I hope you find it, I''ll be more careful next time."]',
                              '['''', '''', '''', '''', ''por lo menos'', ''cuidado'']',
                              '["Hi, it''s your neighbour from number 5.", ''Yeah, a few weeks ago my package was delivered here, do you have it?'', ''It says here on the delivery email that it was delivered here, and this picture shows it at your door.'', ''About two weeks ago.'', ''Why would she collect my package?'', "Okay, thank you for telling me. I''ll go to her door and ask."]',
                              '['''', '''', '''', '''', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV60',
                              'L1',
                              'A2',
                              'C20',
                              'S54',
                              'present simple, modals',
                              'just in time, scarf',
                              '["Hello, I''m back.", "You should wear a jacket, it''s cold today.", "The sky is clear but it''s very windy.", ''Where are you going?'', "We don''t have any milk, can you get some.", ''Bye.'']',
                              '['''', '''', '''', '''', '''', '''']',
                              '["Welcome home. Just in time, I''m about to leave now.", ''Is it? But it is sunny.'', "I''ll bring a scarf too.", "I''m going to the supermarket, do you want anything?", ''Sure, see you in a bit.'']',
                              '[''justo a tiempo'', '''', ''bufanda'', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV61',
                              'L1',
                              'B2',
                              'C8',
                              'S55',
                              'past perfect, past simple',
                              'a date, ghosted, keen, such a shame, there''s plenty more fish in the sea',
                              '[''Hi Peter. How was your weekend?'', ''What happened?'', "That''s awful.", ''Do you have a picture of her?'', "Oh wow, she looks like a model. Are you sure she wasn''t a catfish.", "Best to just forget about it, there''s plenty more fish in the sea."]',
                              '['''', '''', '''', '''', '''', ''hay muchos más peces en el mar '']',
                              '[''Could have been better.'', ''I was supposed to go on a date but she ghosted me.'', "She seemed keen but then on the day I just didn''t hear from her at all. Such a shame because we really clicked, we like the same music and we had a lot to talk about. ", ''Here'', "I didn''t think about it, I guessed she was real when she agreed to meet up. You could be right."]',
                              '['''', ''una fecha / me desertó'', ''entusiasta / Una pena'', '''', '''']'
                          );

INSERT INTO Conversations (
                              ConversationID,
                              languageID,
                              levelID,
                              ContextID,
                              SubContextID,
                              Grammar,
                              KeyVocab,
                              PersonAText,
                              PersonAKey,
                              PersonBText,
                              PersonBKey
                          )
                          VALUES (
                              'CONV0',
                              'L1',
                              'A1',
                              'C1',
                              'S1',
                              'Present simple, do you have?',
                              'reservation, wait, about, takaway',
                              '[''Hi there. Do you have a table for 2?'', "I''m sorry I don''t. ", ''How long is the wait for a table? I am very hungry. '', ''Yes please. I will have two burgers and two portions of fries. Oh and two large drinks. Thank you very much.'', ''You too. '']',
                              '['''', '''', ''espera'', '''', '''']',
                              '[''Good evening. Do you have a reservation with us?'', "I''m afraid we''re very busy tonight so there are no free tables. Would you like to wait or come back later?", "It is about one hour. I''m sorry about that. Would you like to order your food for takeaway instead? ", ''No problem. Your food should be here soon. Have a nice evening!'']',
                              '[''reservación'', '''', ''sobre / llevar '', '''']'
                          );


-- Table: Lang
DROP TABLE IF EXISTS Lang;

CREATE TABLE Lang (
    languageID VARCHAR (99),
    lang       VARCHAR (99) NOT NULL,
    CONSTRAINT languageID_pk PRIMARY KEY (
        languageID
    )
);

INSERT INTO Lang (
                     languageID,
                     lang
                 )
                 VALUES (
                     'L1',
                     'Spanish'
                 );

INSERT INTO Lang (
                     languageID,
                     lang
                 )
                 VALUES (
                     'L2',
                     'German'
                 );

INSERT INTO Lang (
                     languageID,
                     lang
                 )
                 VALUES (
                     'L3',
                     'Portugese'
                 );

INSERT INTO Lang (
                     languageID,
                     lang
                 )
                 VALUES (
                     'L4',
                     'French'
                 );

INSERT INTO Lang (
                     languageID,
                     lang
                 )
                 VALUES (
                     'L5',
                     'Italian'
                 );

INSERT INTO Lang (
                     languageID,
                     lang
                 )
                 VALUES (
                     'L6',
                     'Russian'
                 );


-- Table: Levels
DROP TABLE IF EXISTS Levels;

CREATE TABLE Levels (
    levelID VARCHAR (99),
    Lvl     VARCHAR (99) NOT NULL,
    CONSTRAINT levelID_pk PRIMARY KEY (
        levelID
    )
);

INSERT INTO Levels (
                       levelID,
                       Lvl
                   )
                   VALUES (
                       'A1',
                       'A1'
                   );

INSERT INTO Levels (
                       levelID,
                       Lvl
                   )
                   VALUES (
                       'A2',
                       'A2'
                   );

INSERT INTO Levels (
                       levelID,
                       Lvl
                   )
                   VALUES (
                       'B1',
                       'B1'
                   );

INSERT INTO Levels (
                       levelID,
                       Lvl
                   )
                   VALUES (
                       'B2',
                       'B2'
                   );


-- Table: RegularUser
DROP TABLE IF EXISTS RegularUser;

CREATE TABLE RegularUser (
    EmailAddress VARCHAR (99),
    Pass         VARCHAR (99) NOT NULL,
    UserID       INTEGER      UNIQUE
                              NOT NULL,
    FirstName    VARCHAR (99) NOT NULL,
    LastName     VARCHAR (99) NOT NULL,
    IsTeacher    BOOLEAN      NOT NULL,
    CONSTRAINT email_pk PRIMARY KEY (
        EmailAddress
    )
);

INSERT INTO RegularUser (
                            EmailAddress,
                            Pass,
                            UserID,
                            FirstName,
                            LastName,
                            IsTeacher
                        )
                        VALUES (
                            'user@atlas.com',
                            'user123',
                            'user1',
                            'Example ',
                            'User',
                            0
                        );


-- Table: SubContext
DROP TABLE IF EXISTS SubContext;

CREATE TABLE SubContext (
    SubContextID VARCHAR (99),
    SubContext   VARCHAR (99) NOT NULL,
    CONSTRAINT SubContextID_pk PRIMARY KEY (
        SubContextID
    )
);

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S1',
                           'Takeaway'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S10',
                           'Interview arrangements'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S11',
                           'Dentist'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S12',
                           'Coffee Order'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S13',
                           'Spelling your name'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S14',
                           'Inteview'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S15',
                           'Water for table'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S16',
                           'Reservation'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S17',
                           'Sick relative'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S18',
                           'Charity'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S19',
                           'Lunch'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S2',
                           'Social Media'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S20',
                           'Phone purchase'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S21',
                           'Delayed drinks order'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S22',
                           'Instagram'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S23',
                           'Family size'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S24',
                           'QR Code'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S25',
                           'Doctor'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S26',
                           'Study plans'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S27',
                           'Expired Ticket'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S28',
                           'E.ticket'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S29',
                           'Age restricted'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S3',
                           'Payment'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S30',
                           'neighbours parcel'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S31',
                           'Ist day in job'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S32',
                           'Job offer'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S33',
                           'Hospital Visit'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S34',
                           'Cancel hair appointment'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S35',
                           'Cocktails'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S36',
                           'Cocktails by card payment'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S37',
                           'Disneyland'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S38',
                           'Help with childs birthday party'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S39',
                           'Description of town'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S4',
                           'Booking'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S40',
                           'Purchase of computer'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S41',
                           'Study in cafe'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S42',
                           'Hair cut'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S43',
                           'Rain in station'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S44',
                           'International Food'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S45',
                           'Succulent'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S46',
                           'Children at wedding'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S47',
                           'Wedding RSVP'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S48',
                           'Omelette'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S49',
                           'Meet for drinks'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S5',
                           'Repeat name'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S50',
                           'Ordering cocktails by barcode'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S51',
                           'Offering help for Pink Unicorn Party'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S52',
                           'Visiting patient'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S53',
                           'Delivery of packages'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S54',
                           'Clothing for weather'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S55',
                           'No Show date'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S6',
                           'Cover'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S7',
                           'Refund'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S8',
                           'Delivery Driver'
                       );

INSERT INTO SubContext (
                           SubContextID,
                           SubContext
                       )
                       VALUES (
                           'S9',
                           'Vegan pizza'
                       );


-- Table: UserActivity
DROP TABLE IF EXISTS UserActivity;

CREATE TABLE UserActivity (
    activityID     VARCHAR (99),
    loginTimestamp DATETIME     NOT NULL,
    logoutTimestam DATETIME     NOT NULL,
    EmailAddress   VARCHAR (99) NOT NULL,
    CONSTRAINT activityID_pk PRIMARY KEY (
        activityID
    ),
    CONSTRAINT UserEmail_pk FOREIGN KEY (
        EmailAddress
    )
    REFERENCES RegularUser (EmailAddress),
    CONSTRAINT AdminEmail_pk FOREIGN KEY (
        EmailAddress
    )
    REFERENCES Administrator (EmailAddress) 
);


-- Table: UserConversationInteraction
DROP TABLE IF EXISTS UserConversationInteraction;

CREATE TABLE UserConversationInteraction (
    EmailAddress           VARCHAR (99),
    ConversationID         VARCHAR (99) NOT NULL,
    pairID                 VARCHAR (99) NOT NULL,
    interactionDateAndTime DATETIME     NOT NULL,
    NumOfHintsUSed         INTEGER      NOT NULL,
    ConversationCompleted  BOOLEAN      NOT NULL,
    CONSTRAINT interactionID_pk PRIMARY KEY (
        EmailAddress,
        ConversationID,
        pairID,
        interactionDateAndTime
    ),
    CONSTRAINT InteractionUserEmail_pk FOREIGN KEY (
        EmailAddress
    )
    REFERENCES RegularUser (EmailAddress),
    CONSTRAINT ConversationID_pk FOREIGN KEY (
        ConversationID
    )
    REFERENCES Conversations (ConversationID) 
);


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
