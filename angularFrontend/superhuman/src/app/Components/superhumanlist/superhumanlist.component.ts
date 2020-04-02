import { Component, OnInit } from '@angular/core';
import { Superhuman } from 'src/models/superhumans';
import { SuperServiceService } from 'src/app/super-service.service';

@Component({
  selector: 'app-superhumanlist',
  templateUrl: './superhumanlist.component.html',
  styleUrls: ['./superhumanlist.component.css']
})
export class SuperhumanlistComponent implements OnInit {


  // private _super_name: String;
  // private _alignment_type: String;
  // private _actual_name: String;
  // private _country: String;
  // private _power_description: String;
  // private _team_name: String;


displayedColumns: string[] = ['Super Name', 'Alignment', 'Actual Name', 'Country', 'Power Description', 'Team Name'];
//superhuman: Superhuman;
dataSource: Superhuman[];



  constructor(private superService: SuperServiceService) { }

  ngOnInit(): void {

      this.superService.getAllSuperhumans().subscribe((superhuman:Superhuman[])=>this.dataSource = superhuman);




  }

}
