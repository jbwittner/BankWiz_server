--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2 (Debian 17.2-1.pgdg120+1)
-- Dumped by pg_dump version 17.2 (Debian 17.2-1.pgdg120+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Data for Name: user_accounts; Type: TABLE DATA; Schema: public; Owner: bankwiz_user
--

COPY public.user_accounts (user_id, auth_id, email, full_name, nick_name) FROM stdin;
27de2b0a-b3d2-11ef-b2c4-7f49e866ec08	google-oauth2|105604612464063462418	jeanbaptiste.wittner@gmail.com	Jean-Baptiste Wittner	jeanbaptiste.wittner
\.


--
-- PostgreSQL database dump complete
--

