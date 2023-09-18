import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AreaDirectivaComponent } from './area-directiva.component';

describe('AreaDirectivaComponent', () => {
  let component: AreaDirectivaComponent;
  let fixture: ComponentFixture<AreaDirectivaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AreaDirectivaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AreaDirectivaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
