# Swagger for Sinatra

## Overview
This is a project to provide Swagger support inside the [Grape](https://github.com/intridea/grape) framework.  You can find
out more about both the spec and the framework at http://swagger.io.

## Prerequisites
You need to install ruby 1.9.3 and the following gems:

```
rack
grape
grape-entity
json
rack-cors
grape-swagger
mime-types
nokogiri
```

## Getting started
This sample was generated with the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.

```
rackup p 4567 config.ru
```

In your [swagger ui](https://github.com/swagger-api/swagger-ui), put in the following URL:

```
http://localhost:4567/resources.json
```

## Issue/Feedback
For any issue/feedback, please open an [issue](https://github.com/swagger-api/swagger-codegen/issues)

## Pull Request
We welcome enhancements or bug fixes via pull requests, which should be submitted again the `develop_2.0` branch.

