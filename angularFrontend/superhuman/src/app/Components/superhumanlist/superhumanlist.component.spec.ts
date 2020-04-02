import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuperhumanlistComponent } from './superhumanlist.component';

describe('SuperhumanlistComponent', () => {
  let component: SuperhumanlistComponent;
  let fixture: ComponentFixture<SuperhumanlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuperhumanlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuperhumanlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
