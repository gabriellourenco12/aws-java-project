<a name="readme-top"></a>

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/gabriellourenco12/aws-java-project">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">AWS Project</h3>

  <p align="center">
    Product controller that stores sales in a database and sends an email to the customer.
    <br />
    <a href="https://github.com/gabriellourenco12/aws-java-project"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/gabriellourenco12/aws-java-project">View Demo</a>
    ·
    <a href="https://github.com/gabriellourenco12/aws-java-project/issues">Report Bug</a>
    ·
    <a href="https://github.com/gabriellourenco12/aws-java-project/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#software-architecture">Software Architecture</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

![Product Name Screen Shot][product-screenshot]

This project was developed during the AWS Developer Associate course. The project consists of a product controller that stores sales in a database and sends an email to the customer. Also is possible to list all products, get a specific product by id and input invoices at bucket S3.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* [![Java][Java]][Java-url]
* [![Spring][Spring.io]][Spring-url]
* [![AWS][Aws.amazon]][Aws-url]
* [![Docker][Docker.com]][Docker-url]
* [![Redis][Redis.io]][Redis-url]
* [![MariaDB][MariaDB.org]][MariaDB-url]
* [![Maven][Maven.Apache]][Maven-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* LocalStack
  ```sh
  pip install localstack
  ```
  
* Docker
  ```sh
  sudo apt-get install docker-ce docker-ce-cli containerd.io docker-compose-plugin
  ```
  
### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/gabriellourenco12/aws-java-project.git
   ```
2. Run localstack in docker
   ```sh
   docker run --rm -p 4566:4566 -p 4571:4571 localstack/localstack -e "SERVICES=sns, sqs, dynamodb, s3" 
   ```
3. Config your environment variables to local
   ```sh
   spring.profiles.active=local
   ```

4. Run the application locally

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- Software Architecture -->
## Software Architecture

These are the components used to implement the system.

![Project Architecture][architecture-screenshot]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Gabriel Lourenço - [@gabriellournco_](https://twitter.com/gabriellournco_) - gabriellourenco12ti@gmail.com

Project Link: [https://github.com/gabriellourenco12/aws-java-project](https://github.com/gabriellourenco12/aws-java-project)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Siecola Code](https://siecola.com.br/courses/aws_ecs_java_pt.html)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/gabriellourenco12/aws-java-project.svg?style=for-the-badge
[contributors-url]: https://github.com/gabriellourenco12/aws-java-project/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/gabriellourenco12/aws-java-project.svg?style=for-the-badge
[forks-url]: https://github.com/gabriellourenco12/aws-java-project/network/members
[stars-shield]: https://img.shields.io/github/stars/gabriellourenco12/aws-java-project.svg?style=for-the-badge
[stars-url]: https://github.com/gabriellourenco12/aws-java-project/stargazers
[issues-shield]: https://img.shields.io/github/issues/gabriellourenco12/aws-java-project.svg?style=for-the-badge
[issues-url]: https://github.com/gabriellourenco12/aws-java-project/issues
[license-shield]: https://img.shields.io/github/license/gabriellourenco12/aws-java-project.svg?style=for-the-badge
[license-url]: https://github.com/gabriellourenco12/aws-java-project/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/gabriellourenco12
[product-screenshot]: images/screenshot.png
[architecture-screenshot]: images/screenshot-arq.png
[Java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://www.java.com/
[Spring.io]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io/
[Aws.amazon]: https://img.shields.io/badge/Amazon%20AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white
[Aws-url]: https://aws.amazon.com
[Docker.com]: https://img.shields.io/badge/Docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white
[Docker-url]: https://www.docker.com/
[Redis.io]: https://img.shields.io/badge/Redis-%23DC382D.svg?style=for-the-badge&logo=redis&logoColor=white
[Redis-url]: https://redis.io/
[MariaDB.org]: https://img.shields.io/badge/MariaDB-%2300f.svg?style=for-the-badge&logo=mariadb&logoColor=white
[MariaDB-url]: https://mariadb.org/
[Maven.Apache]: https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white
[Maven-url]: https://maven.apache.org/
