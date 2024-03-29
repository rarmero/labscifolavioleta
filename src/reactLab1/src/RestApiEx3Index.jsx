import RestApiEx3 from './RestApiEx3';
import PrintGraphic from './PrintGraphic'
import commits from './commits.json'

export default function RestApiEx3Index() {


    return (
      <>
       <h1>Commits </h1>
   

      <RestApiEx3
      userRepo={'protossgp32'}
      repository={'CIFO-Web-Applications'}
      url ={'https://api.github.com/repos/protossgp32/CIFO-Web-Applications/commits'}
      />
      <RestApiEx3
       userRepo={'aznale'}
       repository={'aznale.github.io'}
       url={'https://api.github.com/repos/aznale/aznale/commits'}
      
       />
      <RestApiEx3
      userRepo={'DavidMaqueda'}
      repository={'testtest3'}
      url={'https://api.github.com/repos/DavidMaqueda/testtest3/commits'}
     
      />
      <RestApiEx3
      userRepo={'albertmbu'}
      repository={'wiki'}
      url={'https://api.github.com/repos/albertmbu/wiki/commits'}
      />
      <RestApiEx3
      userRepo={'rudevops'}
      repository={'miweb'}
      url={'https://api.github.com/repos/rudevops/miweb/commits'}
      />
      <RestApiEx3
      userRepo={'vallvicity'}
      repository={'CursoDAW'}
      url={'https://api.github.com/repos/vallvicity/CursoDAW/commits'}
      />
      <RestApiEx3
      userRepo={'leonpurple'}
      repository={'combobackend'}
      url={'https://api.github.com/repos/leonpurple/combobackend/commits'}
      />
     <RestApiEx3
      userRepo={'vcalvache'}
      repository={'mywebsite'}
      url={'https://api.github.com/repos/vcalvache/mywebsite/commits'}
      />
      <RestApiEx3
      userRepo={'rarmero'}
      repository={'appwebcifolavioleta'}
      url={'https://api.github.com/repos/rarmero/appwebcifolavioleta/commits'}
      />
   
   <PrintGraphic items={commits} />

    </>
    );
   }
   