

export class Superhuman {

    private super_name: String;
   
    private alignment_type: String;
   
    private actual_name: String;
   
    private country: String;
   
    private power_description: String;
   
    private team_name: String;
    

    constructor(super_name:String, alignment_type:String, actual_name: String, country: String, power_description: String, team_name: String){

        this.super_name = super_name;
        this.alignment_type = alignment_type;
        this.actual_name = actual_name;
        this.country = country;
        this.power_description = power_description;
        this.team_name = team_name;

    }

    public get _super_name(): String {
        return this.super_name;
    }
    public set _super_name(value: String) {
        this.super_name = value;
    }

    public get _alignment_type(): String {
        return this.alignment_type;
    }
    public set _alignment_type(value: String) {
        this.alignment_type = value;
    }
    public get _actual_name(): String {
        return this.actual_name;
    }
    public set _actual_name(value: String) {
        this.actual_name = value;
    }
    public get _country(): String {
        return this.country;
    }
    public set _country(value: String) {
        this.country = value;
    }
    public get _power_description(): String {
        return this.power_description;
    }
    public set _power_description(value: String) {
        this.power_description = value;
    }
    public get _team_name(): String {
        return this.team_name;
    }
    public set _team_name(value: String) {
        this.team_name = value;
    }
}