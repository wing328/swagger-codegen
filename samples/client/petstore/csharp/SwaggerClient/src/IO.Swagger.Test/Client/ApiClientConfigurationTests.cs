﻿using NUnit.Framework;
using System;
using System.Collections.Generic;
using IO.Swagger.Client;
using IO.Swagger.Api;
using IO.Swagger.Model;

namespace IO.Swagger.Test
{
	public class ApiClientConfigurationTests
	{
		public ApiClientConfigurationTests ()
		{
		}

		[TearDown ()]
		public void TearDown ()
		{
			// Reset to default, just in case
			IO.Swagger.Client.Configuration.Default.DateTimeFormat = "o";
		}

		[Test ()]
		public void TestAuthentication ()
		{
			IO.Swagger.Client.Configuration c = new IO.Swagger.Client.Configuration ();
			c.Username = "test_username";
			c.Password = "test_password";

			c.ApiKey ["api_key_identifier"] = "1233456778889900";
			c.ApiKeyPrefix ["api_key_identifier"] = "PREFIX";
			Assert.AreEqual (c.GetApiKeyWithPrefix("api_key_identifier"), "PREFIX 1233456778889900");

		}

		[Test ()]
		public void TestBasePath ()
		{	
			PetApi p = new PetApi ("http://new-basepath.com");
			Assert.AreEqual (p.Configuration.ApiClient.RestClient.BaseUrl, "http://new-basepath.com");
			// Given that PetApi is initailized with a base path, a new configuration (with a new ApiClient)
			// is created by default
			Assert.AreNotSame (p.Configuration, IO.Swagger.Client.Configuration.Default);
		}

		[Test ()]
		public void TestDateTimeFormat_Default ()
		{
			// Should default to the Round-trip Format Specifier - "o"
			// https://msdn.microsoft.com/en-us/library/az4se3k1(v=vs.110).aspx#Anchor_8
			Assert.AreEqual("o", IO.Swagger.Client.Configuration.Default.DateTimeFormat);
		}

		[Test ()]
		public void TestDateTimeFormat_UType()
		{
			IO.Swagger.Client.Configuration.Default.DateTimeFormat = "u";

			Assert.AreEqual("u", IO.Swagger.Client.Configuration.Default.DateTimeFormat);
		}

		[Test ()]
		public void TestConstructor()
		{
			IO.Swagger.Client.Configuration c = new IO.Swagger.Client.Configuration (username: "test username", password: "test password");
			Assert.AreEqual (c.Username, "test username");
			Assert.AreEqual (c.Password, "test password");

		}

		[Test ()]
		public void TestDefautlConfiguration ()
		{	
			PetApi p1 = new PetApi ();
			PetApi p2 = new PetApi ();
			Assert.AreSame (p1.Configuration, p2.Configuration);
			// same as the default
			Assert.AreSame (p1.Configuration, IO.Swagger.Client.Configuration.Default);

			IO.Swagger.Client.Configuration c = new IO.Swagger.Client.Configuration ();
			Assert.AreNotSame (c, p1.Configuration);

			PetApi p3 = new PetApi (c);
			// same as c
			Assert.AreSame (p3.Configuration, c);
			// not same as default
			Assert.AreNotSame (p3.Configuration, p1.Configuration);

		}

		[Test ()]
		public void TestUsage ()
		{
			// basic use case using default base URL
			PetApi p1 = new PetApi (); 
			Assert.AreSame (p1.Configuration, IO.Swagger.Client.Configuration.Default, "PetApi should use default configuration");

			// using a different base URL
			PetApi p2 = new PetApi ("http://new-base-url.com/");
			Assert.AreEqual (p2.Configuration.ApiClient.RestClient.BaseUrl.ToString(), "http://new-base-url.com/");

			// using a different configuration
			IO.Swagger.Client.Configuration c1 = new IO.Swagger.Client.Configuration ();
			PetApi p3 = new PetApi (c1);
			Assert.AreSame (p3.Configuration, c1);

			// using a different base URL via a new ApiClient
			ApiClient a1 = new ApiClient ("http://new-api-client.com");
			IO.Swagger.Client.Configuration c2 = new IO.Swagger.Client.Configuration (a1);
			PetApi p4 = new PetApi (c2);
			Assert.AreSame (p4.Configuration.ApiClient, a1);
		}

		[Test ()]
		public void TestTimeout ()
		{
			IO.Swagger.Client.Configuration c1 = new IO.Swagger.Client.Configuration ();
			Assert.AreEqual (100000, c1.Timeout); // default vaue

			c1.Timeout = 50000;
			Assert.AreEqual (50000, c1.Timeout);

			IO.Swagger.Client.Configuration c2 = new IO.Swagger.Client.Configuration (timeout: 20000);
			Assert.AreEqual (20000, c2.Timeout);
		}

	}
}

