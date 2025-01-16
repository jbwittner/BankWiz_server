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
-- Data for Name: currencies; Type: TABLE DATA; Schema: public; Owner: bankwiz_user
--

COPY public.currencies (currency_decimal_digits, currency_id, currency_code, currency_name, currency_symbol) FROM stdin;
2	01947108-b216-7c9a-a39a-d3a27eb5ccbf	EUR	Euro	€
2	01947108-f205-7aec-9203-14884e73f69f	USD	US Dollars	$
0	01947109-ef2a-7b90-972f-5ad4adfe2c91	JPY	Japanese Yen	¥
2	0194710b-09ed-7e75-9387-ffe5abf307df	HKD	Hong Kong Dollar	HKD
\.


--
-- Data for Name: user_accounts; Type: TABLE DATA; Schema: public; Owner: bankwiz_user
--

COPY public.user_accounts (user_id, auth_id, email, full_name, nick_name) FROM stdin;
\.


--
-- Data for Name: bank_accounts; Type: TABLE DATA; Schema: public; Owner: bankwiz_user
--

COPY public.bank_accounts (initial_decimal_balance, bank_account_id, currency_id, user_id, bank_account_name) FROM stdin;
\.


--
-- PostgreSQL database dump complete
--

