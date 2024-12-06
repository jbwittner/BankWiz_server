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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: user_accounts; Type: TABLE; Schema: public; Owner: bankwiz_user
--

CREATE TABLE public.user_accounts (
    user_id uuid NOT NULL,
    auth_id character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    full_name character varying(255) NOT NULL,
    nick_name character varying(255) NOT NULL
);


ALTER TABLE public.user_accounts OWNER TO bankwiz_user;

--
-- Data for Name: user_accounts; Type: TABLE DATA; Schema: public; Owner: bankwiz_user
--

COPY public.user_accounts (user_id, auth_id, email, full_name, nick_name) FROM stdin;
\.


--
-- Name: user_accounts user_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: bankwiz_user
--

ALTER TABLE ONLY public.user_accounts
    ADD CONSTRAINT user_accounts_pkey PRIMARY KEY (user_id);


--
-- PostgreSQL database dump complete
--

